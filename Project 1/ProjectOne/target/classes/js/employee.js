
window.onload = function(){
whoami();



function whoami(){
	//method that provides an easy, logical way to fetch resources asynchronously across the network
	fetch('http://localhost:9003/user/whoami').then( 
		function(response) {
			//Here we are fetching a JSON file across the network and printing it to the console. 
			// takes one argument — the path to the resource you want to fetch — and does not directly 
			//return the JSON response body but instead returns a promise that resolves with a Response object.
			return response.json();
		}, function() {
			console.log('Error');
		}
	).then(function(myJSON){
		console.log("I am : " + myJSON);
		if(myJSON === "EMPLOYEE"){ //check if user is employee
			data(); //call function that will take the employee to the fuction that will get the tickets
		}else{
			//assign the window location to static html file
			window.location.assign("/index.html");
		}
	})
}
function data(){
	//method that provides an easy, logical way to fetch resources asynchronously across the network
	fetch('http://localhost:9003/user/employee/tickets').then( 
		function(response) {
			return response.json();
		}, function() {
			console.log('Error');
		}
	).then(function(myJSON){
		console.log('its me here');
		console.log(myJSON);
		ourDOMManipulation(myJSON);
	})
}

function ourDOMManipulation(jsonResponse){
	var mydata = Object.values(jsonResponse);  //returns an array of a given object's
	let table = document.getElementById("myReimTableData");
	for(let i=0; i<mydata.length; i++){
		//CREATE OUR NEW ELEMENTS
		let tr  = document.createElement("tr");
		
		tr.appendChild(createTableCell(mydata[i].reimId));
		tr.appendChild(createTableCell(mydata[i].reimAmount));
		tr.appendChild(createTableCell(mydata[i].submitDate));
		tr.appendChild(createTableCell(mydata[i].resolvedDate));
		tr.appendChild(createTableCell(mydata[i].reimDescription));
		tr.appendChild(createTableCell(mydata[i].author));
		
		if(mydata[i].resolver != 0){
			tr.appendChild(createTableCell(mydata[i].resolver));
		}else {
			tr.appendChild(createTableCell("Unresolved"));
		}		
		
		tr.appendChild(createTableCell(mydata[i].statusId));
		tr.appendChild(createTableCell(mydata[i].typeId));
		
		table.appendChild(tr);
		console.log(mydata[i].reimbId);
	}
	
}
}
//function used to create table cells
function createTableCell(value){
	let cell  = document.createElement("td");
	cell.appendChild(document.createTextNode(value));
	return cell;
}

