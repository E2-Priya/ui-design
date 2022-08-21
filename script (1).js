
const modal = document.querySelector('#my-modal');
const modalBtn = document.querySelector('#modal-btn');
const closeBtn = document.querySelector('.close');


modalBtn.addEventListener('click', openModal);
closeBtn.addEventListener('click', closeModal);


function openModal() {
  modal.style.display = 'flex';
  selectedIndex=-1;
}

function closeModal() {
  modal.style.display = 'none';
  
  

}

function closeForm() {
  document.getElementById('formContainer').reset();

  var r =document.getElementById('error2')
  r.textContent="";
  
  
}

/* function submitClose(){
    document.getElementById('closing').reset();
} */




var arr = [];
function init() {
  selectedIndex = -1;
  document.getElementById("tableRows").innerHTML = "";
  if (localStorage.record) {
    arr = JSON.parse(localStorage.record);
    for (var i = 0; i < arr.length; i++) {
      var name = arr[i].n;
      var id = arr[i].id;
      var dept = arr[i].dept;
      tableCell(i, name, id, dept);
    }
  }
}
function onReg() {

  var name = document.getElementById("studentName").value;
  var id = document.getElementById("studentId").value;
  var dept = document.getElementById("studentDept").value;

  var obj = { n: name, id: id, dept: dept };
  if (selectedIndex === -1) {
    arr.push(obj);
  }
  else { arr.splice(selectedIndex, 1, obj); }

  console.log(arr);
  localStorage.record = JSON.stringify(arr);

  init();
  
  document.getElementById('formContainer').reset();

}

function tableCell(index, name, id, dept) {
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
  dlt1.innerHTML = '<i onclick="dFunOpen('+index+')" type="button" class="fa-solid fa-trash-can" ></i>';
  edit1.innerHTML = '<i onclick ="editTbl(' + index + ')" type="button"class="fa-solid fa-pen-to-square"></i>';
}


var selectedIndex = -1;
function editTbl(index) {

  modal.style.display = 'flex';
  selectedIndex = index;
  var stuObj = arr[index];
  document.getElementById("studentName").value = stuObj.n;
  document.getElementById("studentId").value = stuObj.id;
  document.getElementById("studentDept").value = stuObj.dept;
  initEdit();

}
function initEdit(){
  document.getElementById("tableRows").innerHTML = "";
  if (localStorage.record) {
    arr = JSON.parse(localStorage.record);
    for (var i = 0; i < arr.length; i++) {
      var name = arr[i].n;
      var id = arr[i].id;
      var dept = arr[i].dept;
      tableCell(i, name, id, dept);
    }
  }
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

  var uname = document.getElementById("error2")
  if ((document.getElementById("studentName").value == ""||document.getElementById("studentId").value == ""||document.getElementById("studentDept").value == "")) {
    uname.textContent = "Please enter all Fields"
    Form.addEventListener("submit",function(e){
      e.preventDefault();
    })



  } else {
    uname.textContent = ""
    onReg();
    closeModal();
    


  }


}
/*function errorMsg11() {

  var upass = document.getElementById("error1")
  if ((document.getElementById("studentId").value == "")) {
    upass.textContent = "Please enter password"
    

  }
  else {
    upass.textContent = ""
  }

}

function errorMsg() {

  var upass = document.getElementById("error1")
  if ((document.getElementById("studentId").value == "")) {
    upass.textContent = "Please enter password"


  }
  else {
    upass.textContent = ""
  }

}

function errorMsg1() {

  var upass = document.getElementById("error2")
  if ((document.getElementById("studentDept").value == "")) {
    upass.textContent = "Please enter Departement"
    validate();

  }
  else {
    upass.textContent = ""
  }

}*/

const dFull = document.querySelector('#dFull');


function dFunOpen(index){
  dFull.style.display='flex';
  var d =index;
  const m = document.getElementById('check');
  m.innerHTML='<button onclick="deleteka('+d+');">CONFIRM</button>'
  
}

function deleteka(d){
  var tbl = document.getElementById("tableRows");

  selectedIndex=d;
  
    tbl.deleteRow(d);
    arr.splice(d, 1);
    localStorage.record = JSON.stringify(arr);
    init();
    dFunClose();
  
    selectedIndex = -1;

}


function dFunClose() {
  dFull.style.display = 'none';

}
