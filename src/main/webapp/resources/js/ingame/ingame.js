const myPet = document.getElementById("myPet");
const petParent = document.getElementById("petParent");


//ArrowLeft ArrowUp ArrowRight ArrowDown

let x = 50;
let y = 100;
let currentPositionX = 50;
let currentPositionY = 100;
let flag = true;

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

myPet.addEventListener("click", ()=>{
    let petChatBtn = document.createElement("button");
    petChatBtn.innerHTML = "대화하기";
    petParent.append(petChatBtn);


    petChatBtn.classList.add('btn', 'btn-warning');
    petChatBtn.setAttribute("id", "petChat");
    petChatBtn.setAttribute("type", "button");
    petChatBtn.setAttribute("data-bs-target", "#chatModal");

    petChatBtn.style.left = currentPositionX;
    petChatBtn.style.top = currentPositionY;
    
})