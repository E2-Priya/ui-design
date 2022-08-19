
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




var arr = [];
function init(){
  document.getElementById("tableRows").innerHTML="";
  if (localStorage.record){
    arr=JSON.parse(localStorage.record);
    for(var i = 0; i<arr.length;i++){
      var name = arr[i].n;
var id  = arr[i].id;
var dept = arr[i].dept;
tableCell(i,name,id,dept);
    }
  }
}
function onReg(){
var name = document.getElementById("studentName").value;
var id  = document.getElementById("studentId").value;
var dept = document.getElementById("studentDept").value;

var obj = {n:name,id:id,dept:dept};
if(selectedIndex===-1){
arr.push(obj);}
else{arr.splice(selectedIndex,1,obj);}

console.log(arr);
localStorage.record= JSON.stringify(arr);

init();
document.getElementById('formContainer').reset();

}

function tableCell(index,name,id,dept){
  var tbl = document.getElementById("tableRows");
  var row = tbl.insertRow();
  var name1 = row.insertCell(0);
  var id1 = row.insertCell(1);
  var dept1 = row.insertCell(2);
  var edit1 = row.insertCell(3);
  var dlt1 = row.insertCell(4);
  name1.innerHTML = name;
  id1.innerHTML = id;
  dept1.innerHTML = dept;
  dlt1.innerHTML = '<i  onclick="DeleteTbl('+index+')" class="fa-solid fa-trash-can"></i>';
  edit1.innerHTML='<i onclick ="editTbl('+index+')" class="fa-solid fa-pen-to-square"></i>';
}

function DeleteTbl(index){
  var tbl = document.getElementById("tableRows");
  tbl.deleteRow(index);
  arr.splice(index,1);
  localStorage.record=JSON.stringify(arr);
  init();
}
var selectedIndex=-1;
function editTbl(index){
  
  modal.style.display='flex';
  selectedIndex = index;
var stuObj = arr[index];
  document.getElementById("studentName").value=stuObj.n;
document.getElementById("studentId").value=stuObj.id;
document.getElementById("studentDept").value=stuObj.dept;


}

/*
function validate(){
  if((document.getElementById("uname").value=="")){
    form.addEventListener("submit",function(e){
      e.preventDefault();

    }
    )
  }
}
*/





function errorMessage() {
    
    var uname = document.getElementById("error")
    if ((document.getElementById("studentName").value==""))
    {
        uname.textContent = "Please enter usename"
        validate();


       
    } else {
        uname.textContent = ""
        
     
    }
  

}

function errorMsg(){

    var upass = document.getElementById("error1")
    if ((document.getElementById("studentId").value==""))
    {
        upass.textContent = "Please enter password"
        validate();
      
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
        validate();
      
    }
    else {
        upass.textContent = ""
    } 

}
