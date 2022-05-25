import Person from './Person.js ';
import PersonComponent from './PersonComponent.js';



const personNameInput = document.getElementById('personNameInput');
const personPositionInput = document.getElementById('personPositionInput');
const regBtn = document.getElementById('regBtn');
const personContainer = document.getElementById('personContainer');
const personIDInput = document.getElementById('personIDInput');


const postUser = async ()=>{

    let data = {
        id: 0,
        username: 'Superman',
        name:'Clark Kent',
        natId:'234234',
        age:23,
        pass:'12334234'
    }

    let res = await fetch(
        `http://localhost:8080/APIRest/api/user/create`,
         {method:'POST', body:JSON.stringify(data), headers:{
                 'Content-Type': 'application/json'
             }}
    );
    console.log(res);
    let obj = await res.json();
    console.log(obj);

}

regBtn.addEventListener('click', (event)=>{
    event.preventDefault();
    let name = personNameInput.value;
    let position = personPositionInput.value;
    let id = personIDInput.value;

    let person = new Person(id, name, position);
    //let component = new PersonComponent(person);

    //component.render(personContainer);
    personNameInput.value = '';
    personPositionInput.value = '';
    personIDInput.value = '';
    postUser()
});

const getPokemon = async (num)=>{
    console.log('----');
    let url = `https://pokeapi.co/api/v2/pokemon/${num}`;
    let response = await fetch(url, {method:'GET'});
    let obj = await response.json();
    console.log(obj);

    let person = new Person(num, obj.name, obj.types[0].type.name);
    person.photo = obj.sprites.front_default;
    let component = new PersonComponent(person);

    component.render(personContainer);
}

const download = async ()=>{
    await getPokemon(34);
    await getPokemon(23);
    await getPokemon(234);
    await getPokemon(35);
    await getPokemon(123);
    await getPokemon(744);
    await getPokemon(542);
    await getPokemon(634);
    await getPokemon(245);
}

//setInterval

const getUsersAPI = async ()=>{
    let url = `http://localhost:8080/APIRest/api/user/all/1`;
    let response = await fetch(url, {method:'GET'});
    let obj = await response.json();
    console.log(obj);

    for(let i in obj){
        let person = new Person(obj[i].id, obj[i].name, obj[i].username);
        let component = new PersonComponent(person);
        component.render(personContainer);
    }

}

getUsersAPI();

let user = window.localStorage.getItem('user');
console.log(user);

if(user != null){
    window.location.href = 'detail.html';
}

