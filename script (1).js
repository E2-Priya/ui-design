
const modal = document.querySelector('#my-modal');
const modalBtn = document.querySelector('#modal-btn');
const closeBtn = document.querySelector('.close');


modalBtn.addEventListener('click', openModal);
closeBtn.addEventListener('click', closeModal);


function openModal() {
  modal.style.display = 'flex';
}

function closeModal() {
  modal.style.display = 'none'; 
}

function closeForm(){
  document.getElementById('formContainer').reset();
}
  
/* function submitClose(){
    document.getElementById('closing').reset();
} */

var arr= new Array();
function addData(){
  getData();
  arr.push({
    studentName:document.getElementById("studentName").value,
    studentId:document.getElementById("studentId").value,
    studentDept:document.getElementById("studentDept").value
  });

  localStorage.setItem("localData",JSON.stringify(arr));
  showData();
  document.getElementById('formContainer').reset();
}

function getData(){
  var str = localStorage.getItem("localData");
    if(str !=null) 
    arr=JSON.parse(str);
}

function deteleData(){
  localStorage.clear(); 
}

function showData(){

 /*  getData(); */
  var tbl = document.getElementById("myTable");
  var x =tbl.rows.length;
  while(--x){
    tbl.deleteRow(x);
  }

  for(i=0;i<arr.length;i++){
  var r = tbl.insertRow();
  var cell1 = r.insertCell();
  var cell2 = r.insertCell();
  var cell3 = r.insertCell();
  var cell4 = r.insertCell();
  var cell5 = r.insertCell();

  cell1.innerHTML=arr[i].studentName;
  cell2.innerHTML=arr[i].studentId;
  cell3.innerHTML=arr[i].studentDept;
  cell4.innerHTML=`<i onclick="deleteForm(this)" class="fa-solid fa-trash-can"></i>`
  cell5.innerHTML=`<i onclick="editForm()" class="fa-solid fa-pen-to-square"></i>`
   }

}


let deleteForm=function(e)
{
   e.parentElement.parentElement.remove();
}

function editForm(){
  modal.style.display='flex';
}



function errorMessage() {
    
    var uname = document.getElementById("error")
    if ((document.getElementById("studentName").value==""))
    {
        uname.textContent = "Please enter usename"
       
    } else {
        uname.textContent = ""
    }
  

}

function errorMsg(){

    var upass = document.getElementById("error1")
    if ((document.getElementById("studentId").value==""))
    {
        upass.textContent = "Please enter password"
      
    }
    else {
        upass.textContent = ""
    } 

}

function errorMsg1(){

    var upass = document.getElementById("error2")
    if ((document.getElementById("studentDept").value==""))
    {
        upass.textContent = "Please enter password"
      
    }
    else {
        upass.textContent = ""
    } 

}