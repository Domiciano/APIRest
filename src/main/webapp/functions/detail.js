const json = window.localStorage.getItem('user');
if(json == null){
    window.location.href = 'index.html';
}

const user = JSON.parse(  json  );





const userName = document.getElementById('userName');
const userPosition = document.getElementById('userPosition');
const closeBTN = document.getElementById('closeBTN');

userName.innerHTML = user.name;
userPosition.innerHTML = user.position;

closeBTN.addEventListener('click', (event)=>{
    window.localStorage.removeItem('user');
    window.location.href = "index.html";
})