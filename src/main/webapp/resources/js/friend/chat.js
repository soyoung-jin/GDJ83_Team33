const sendBtn = document.getElementById("sendBtn"); //메세지 보내는 버튼
const modalContent = document.getElementById("modalContent");
const chatContent = document.getElementById("chatContent");
const startChat = document.getElementById("startChat");
let div = document.createElement("div");



//==================친구와 채팅 - 웹소켓===================


let sock = new SockJS("http://192.168.7.108/friend/friendDetail");


sock.onmessage = onMessage;
sock.onclose = onClose;

// 메세지 전송
function sendMessage(){
    sock.send(chatContent.value);
    
}

// 서버로부터 메세지를 받았을 때
function onMessage(msg) {
    let h3 = document.createElement("h3");
    h3.setAttribute("id", "yourMsg");
    if (loginYourId == msg.senderNo) {
        h3.setAttribute("id", "myMsg");
    }
    console.log(msg);
    let data = msg.data;
    h3.append(data);
    div.append(h3);
    modalContent.append(div);
    
    
}

function onClose() {
    let h3 = document.createElement("h3");
    h3.append("연결 끊김");
    div.append(h3);
    modalContent.append(div);
}


chatContent.addEventListener("keyup", (e)=>{
    if(e.key === 'Enter') {
        sendMessage();
        console.log(chatContent.value);
        chatContent.value="";


    }
})

sendBtn.addEventListener("click", ()=>{
    
    sendMessage();
    console.log(chatContent.value);
    chatContent.value="";

})

startChat.addEventListener("click", ()=>{
    chatContent.value="";
    div.remove();
    div.innerHTML = "";
})