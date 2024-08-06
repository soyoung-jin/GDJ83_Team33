const myPet = document.getElementById("myPet");
const myPetBtn = document.getElementById("myPetBtn");
const petParent = document.getElementById("petParent");


//ArrowLeft ArrowUp ArrowRight ArrowDown

let x = 50;
let y = 100;
let currentPositionX = 0;
let currentPositionY = 0;


document.addEventListener("keydown", (e)=>{
    if(e.key==='ArrowLeft') {
        x = x-5;
        myPet.style.left = x+"px";
        currentPositionX = myPet.style.left;
    } else if(e.key==='ArrowRight') {
        x = x+5;
        myPet.style.left = x+"px";
        currentPositionX = myPet.style.left;
    } else if(e.key==='ArrowUp') {
        y = y-5;
        myPet.style.top = y+"px";
        currentPositionY = myPet.style.top
    } else if(e.key==='ArrowDown') {
        y = y+5;
        myPet.style.top = y+"px";
        currentPositionY = myPet.style.top
    }
})

myPetBtn.addEventListener("click", ()=>{
    let petChat = document.createElement("button");
    petParent.append(petChat);
    petChat.innerHTML = "대화하기";
    petChat.classList.add('btn', 'btn-warning');
    petChat.setAttribute("id", "petChat");
    petChat.setAttribute("type", "button");
})