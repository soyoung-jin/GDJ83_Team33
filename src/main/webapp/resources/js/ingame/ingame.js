const myPet = document.getElementById("myPet");
const petParent = document.getElementById("petParent");


//ArrowLeft ArrowUp ArrowRight ArrowDown

let x = 500;
let y = 400;
let currentPositionX = 450;
let currentPositionY = 350;
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
        currentPositionY = myPet.style.top;
    } else if(e.key==='ArrowDown') {
        y = y+5;
        myPet.style.top = y+"px";
        currentPositionY = myPet.style.top
    }
})



// petParent.addEventListener("click", (e)=>{
//     if(e.target.id=="petChat"){
//     }
// })

myPet.addEventListener("click", ()=>{
    
    console.log("2")
    
    // fetch("./ingameChat", {
        //     method: "GET"
        // })
        
        let petChatBtn = document.createElement("button");
        petChatBtn.setAttribute("type", "button");
        petChatBtn.classList.add('btn', 'btn-outline-warning');
        petChatBtn.setAttribute("id", "petChat");
        petChatBtn.innerHTML = "대화하기";
        petChatBtn.setAttribute("data-bs-toggle", "modal");
        petChatBtn.setAttribute("data-bs-target", "#commentModal");
        
    petParent.append(petChatBtn);

    petChatBtn.style.left = currentPositionX;
    petChatBtn.style.top = currentPositionY;
    
})
