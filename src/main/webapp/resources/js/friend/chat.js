const sendBtn = document.getElementById("sendBtn"); //메세지 보내는 버튼
const startChat = document.getElementById("startChat"); //채팅하기 버튼

const chatContent = document.getElementById("chatContent"); //보내는 메세지(input의 value)
const modalContent = document.getElementById("modalContent"); //모달 안의 채팅 내용

let div = document.createElement("div"); //모달 안에 추가될 글들의 부모



//==================친구와 채팅===================

// *********웹소켓 연결을 원하는 모든 jsp에 이 자바스크립트 파일을 넣어줘야 됨********
let sock = new SockJS("http://192.168.7.108/friend/friendDetail");

// 연결이 되었을 때


// 웹소켓을 통해 메세지를 받았을 때 실행
// 클라이언트가 서버로부터 메세지를 받았을 때 실행
sock.onmessage = onMessage;

// 연결이 끊겼을 때 실행
sock.onclose = onClose;

// 메세지 전송
function sendMessage(){
    // 서버로 데이터를 전송
    sock.send(chatContent.value);

    // 나: 보낸내용
    console.log(loginUserId + ": " + chatContent.value);
}

// 메세지 수신
function onMessage(msg) {
    
    // 메세지 내용
    let data = msg.data; 
    
    //한 줄 추가
    let h3 = document.createElement("h3");
    h3.append(data);
    div.append(h3);
    modalContent.append(div);
    
    // 친구: 보낸내용
    console.log(loginFriendId + ": " + data);
    
}


// 연결이 끊김
function onClose() {
    let h3 = document.createElement("h3");
    h3.append("연결 끊김");
    div.append(h3);
    modalContent.append(div);
}

//========================같은 기능=========================
chatContent.addEventListener("keyup", (e)=>{
    if(e.key === 'Enter') {
        sendMessage();
        chatContent.value="";


    }
})
sendBtn.addEventListener("click", ()=>{
    sendMessage();
    chatContent.value="";

})
//===========================================================

// 채팅하기 버튼 클릭시
startChat.addEventListener("click", ()=>{
    chatContent.value="";
    div.remove();
    div.innerHTML = "";
})