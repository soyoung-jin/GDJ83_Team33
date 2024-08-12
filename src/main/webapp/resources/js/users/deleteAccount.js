const user_pw = document.getElementById("user_pw");
const user_pw2 = document.getElementById("user_pw2");

const error_message = document.getElementById("error-message");


user_pw2.addEventListener("blur", ()=>{

    if(user_pw2.value != user_pw.value){
        error_message.innerHTML="비밀번호가 일치하지 않습니다";
        error_message.classList="text-danger";
        user_pw2.value="";
    }else{
        error_message.innerHTML="";
    }
})