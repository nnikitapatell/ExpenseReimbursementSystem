
window.onload = function(){
whoami();

function whoami(){
	fetch('http://localhost:9003/user/whoami').then( 
		function(response) {
			return response.json();
		}, function() {
			console.log('Error');
		}
	).then(function(myJSON){
		console.log("I am : " + myJSON);
		
		if(myJSON === "MANAGER"){
			data();
		}else{
			window.location.assign("/index.html");
		}
		
	})
	
}

//this function fetches the http that gets the tickets for manager
function data(){
	fetch('http://localhost:9003/user/manager/tickets').then( 
		function(response) {
			//The json() method of the Response interface takes a Response stream and reads it to completion. 
			//It returns a promise which resolves with the result of parsing the body text as JSON.
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

//dom manipulation 
function ourDOMManipulation(jsonResponse){
	var mydata = Object.values(jsonResponse);
	let table = document.getElementById("myReimTableData");
	for(let i=0; i<mydata.length; i++){
		//CREATE OUR NEW ELEMENTS
		let tr  = document.createElement("tr");
		
		tr.appendChild(createTableCell(mydata[i].reimId));
		tr.appendChild(createTableCell(mydata[i].reimAmount));
		tr.appendChild(createTableCell(mydata[i].submitDate));
		tr.appendChild(createTableCell(mydata[i].resolvedDate));
		tr.appendChild(createTableCell(mydata[i].reimDescription));
		tr.appendChild(createTableCell(mydata[i].authorName));
		tr.appendChild(createTableCell(mydata[i].resolverName));		
		tr.appendChild(createTableCell(mydata[i].status));
		tr.appendChild(createTableCell(mydata[i].type));
		
		table.appendChild(tr);
		console.log(mydata[i].reimbId);
	}
	
}
}

//function to create a table cell
function createTableCell(value){
	let cell  = document.createElement("td"); 
	cell.appendChild(document.createTextNode(value));
	return cell;
}


function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myReimTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[7];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
