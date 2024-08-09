const sendBtn = document.getElementById("sendBtn");
const modalContent = document.getElementById("modalContent");
const chatContent = document.getElementById("chatContent");
const startChat = document.getElementById("startChat");
let div = document.createElement("div");

function chatting () {
    let h3 = document.createElement("h3");
    h3.append(chatContent.value);
    div.append(h3);
    modalContent.append(div);
}

chatContent.addEventListener("keyup", (e)=>{
    if(e.key === 'Enter') {
        chatting();
        chatContent.value="";

    }
})

sendBtn.addEventListener("click", ()=>{
    chatting();
    chatContent.value="";
})

startChat.addEventListener("click", ()=>{
    chatContent.value="";
    div.remove();
    div.innerHTML = "";
})