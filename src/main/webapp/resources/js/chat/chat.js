const sendBtn = document.getElementById("sendBtn");
const modalContent = document.getElementById("modalContent");
const chatContent = document.getElementById("chatContent");

function chatting () {
    let h1 = document.createElement("h1");
    h1.append(chatContent.value);
    modalContent.append(h1);
}

chatContent.addEventListener("keyup", (e)=>{
    if(e.key === 'Enter') {
        chatting();
    }
})

sendBtn.addEventListener("click", ()=>{
    chatting();
})