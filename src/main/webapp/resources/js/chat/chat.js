const sendBtn = document.getElementById("sendBtn");
const modalContent = document.getElementById("modalContent");
const chatContent = document.getElementById("chatContent");
const startChat = document.getElementById("startChat");
let div = document.createElement("div");

function chatting () {
    let h1 = document.createElement("h1");
    h1.append(chatContent.value);
    div.append(h1);
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
})