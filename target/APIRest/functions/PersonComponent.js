export default class PersonComponent{


    //State
    constructor(person){
        this.person = person;
    }

    render(container){
        let html = `
            <div class="card" style="width: 18rem;">
            <img src="${this.person.photo}" class="card-img-top" alt="...">
            <div class="card-body">
            <h5 class="card-title">${this.person.name}</h5>
            <p class="card-text">${this.person.position}</p>
            <a href="#" id="button${this.person.id}" class="btn btn-primary">Ver perfil</a>
            </div>
        </div>
        `;
        let root = document.createElement('div');
        root.innerHTML = html.trim();
        container.appendChild(root.firstChild);

        let button = document.getElementById(`button${this.person.id}`);
        button.addEventListener('click', this.action.bind(this));
    }

    action(event){
        event.preventDefault();
        let json = JSON.stringify(this.person);
        console.log(json);
        window.localStorage.setItem('user', json);
        window.location.href = "detail.html";
    }

}