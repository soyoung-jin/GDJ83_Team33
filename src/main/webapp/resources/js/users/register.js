const blankCheck = document.getElementById("blankCheck");
const user_id = document.getElementById("user_id");
const user_pw = document.getElementById("user_pw");
const user_pw2 = document.getElementById("user_pw2");
const user_name = document.getElementById("user_name");
const user_nickname = document.getElementById("user_nickname");
const user_phone = document.getElementById("user_phone");
const user_email = document.getElementById("user_email");
// input태그를 감싸는 div태그의 클래스
const form_control = document.getElementsByClassName("form-control");
// 비밀번호 검증 결과를 띄워주는 div 태그의 id
const error_message = document.getElementById("error-message");
// 비밀번호 길이 제한 검증 div 태그의 id
const length_check = document.getElementById("length-check");
const duplicate_check = document.getElementById("duplicate-check");
const form = document.getElementById("form");



// 회원가입시 입력란이 비어있으면 alert창을 띄워주는 함수
// 공백칸으로 focus가 향하도록 설계
blankCheck.addEventListener("click", ()=>{

    // 비밀번호 검증 이벤트는 2차 비밀번호에 걸려있음,
    // 검증 통과 후 1차 비밀번호를 수정하는 케이스를 방지하기 위해 버튼 클릭시 검증을 한번 더 진행함
    if(user_pw.value != user_pw2.value){
        user_pw.value="";
    }

    if(user_id.value=="" || user_pw.value=="" || user_pw2.value=="" || user_name.value=="" || 
        user_nickname.value=="" || user_phone.value=="" || user_email.value==""){
        alert("입력되지 않은 정보가 있습니다.")
        
        for(let f of form_control){
            if(f.value==""){
                f.focus();
                f.style.border = "double 2px red";
                return;
            }else{
                f.style.border = "";
            }
        }
    }else{
        form.submit();
    }
})

// 1차 비밀번호와 2차 비밀번호가 동일한지 검증하는 이벤트
user_pw2.addEventListener("blur", ()=>{

    if(user_pw.value != user_pw2.value){
        user_pw2.value = "";
        error_message.innerHTML="비밀번호가 동일하지 않습니다.";
        error_message.classList = "text-danger";
    }else{
        error_message.innerHTML="비밀번호가 동일합니다.";
        error_message.classList = "text-primary";
    }
})

// 비밀번호 길이가 6자 이상인지 검증하는 이벤트
user_pw.addEventListener("change", ()=>{

    if(user_pw.value.length < 6){
        user_pw.value="";
        length_check.innerHTML="비밀번호 길이는 6자 이상만 가능합니다.";
        length_check.classList="text-danger";
    }else{
        length_check.innerHTML="사용 가능한 비밀번호 입니다.";
        length_check.classList="text-primary";
    }
})

user_id.addEventListener("blur", ()=>{

    let id = user_id.value
    fetch("/users/checkID?user_id=" + id, {
        method:"GET"
    })
    .then((res)=>{return res.text()})
    .then((res)=>{
        if(res > 0){
            duplicate_check.innerHTML="중복된 아이디입니다.";
            duplicate_check.classList="text-danger";
        }else{
            duplicate_check.innerHTML="사용가능한 아이디입니다.";
            duplicate_check.classList="text-primary";
        }
    })
    .catch(()=>{
        alert("오류 발생!");
    })
})