const register_enter = document.querySelector(".register-form");

const VALID = "is-valid";
const INVALID= "is-invalid";

register_enter.addEventListener("submit", function(ev){
    ev.preventDefault();
    const name = register_enter.querySelector(".rName");
    if(name.value===null){
        name.classList.remove(VALID);
        name.classList.add(INVALID);
    }
    else{
        name.classList.remove(INVALID);
        name.classList.add(VALID);
    }
});