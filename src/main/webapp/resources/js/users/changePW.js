const new_pw = document.getElementById("new_pw");
const new_pw2 = document.getElementById("new_pw2");
error_message = document.getElementById("error-message");
error_message2 = document.getElementById("error-message2");
const btn = document.getElementById("btn");


new_pw.addEventListener("blur", ()=>{

    if(new_pw.value.length < 6){
        error_message.innerHTML="비밀번호는 6자 이상입니다";
        error_message.classList="text-danger";
        new_pw.value="";
    }else{
        error_message.innerHTML="사용가능합 비밀번호 입니다";
        error_message.classList="text-primary";
    }
})

new_pw2.addEventListener("blur", ()=>{

    if(new_pw.value != new_pw2.value){
        error_message2.innerHTML="비밀번호가 일치하지 않습니다";
        error_message2.classList="text-danger";
        new_pw2.value="";
    }else{
        error_message2.innerHTML="비밀번호가 일치합니다";
        error_message2.classList="text-primary";
    }
})

btn.addEventListener("click", ()=>{

    if(new_pw.value != new_pw2.value){
        new_pw.value="";
        new_pw2.value="";
        alert("비밀번호가 일치하지 않습니다");
        return;
    }

    if(new_pw.value == "" || new_pw2.value == ""){
        alert("비밀번호를 입력해주세요");
        return;
    }

    btn.type="submit";
})

