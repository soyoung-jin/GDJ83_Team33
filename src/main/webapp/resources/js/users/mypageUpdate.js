const check = document.getElementById("check");
const user_pw = document.getElementById("user_pw");
const user_name = document.getElementById("user_name");
const user_nickname = document.getElementById("user_nickname");
const user_phone = document.getElementById("user_phone");
const user_email = document.getElementById("user_email");
// 비밀번호 검증 결과 보여주는 div id
const password_check = document.getElementById("password-check");
const form = document.getElementById("form");

const regName = /^(?=.*[가-힣])[가-힣]{2,}$/;
const regPhone = /^\d{2,3}-\d{3,4}-\d{4}$/;
const regEmail = /^[A-Za-z-0-9\-\.]+@[A-Za-z-0-9\-\.]+\.[A-Za-z-0-9]+$/;


// 회원 정보 수정시 정규식 검증 이벤트
// 해당 계정의 비밀번호를 입력해야만 회원 정보 수정이 가능하도록 설계
// 비밀번호가 맞는지 ajax를 통해 DB에서 검색을 실시
check.addEventListener("click", ()=>{

    if(user_name.value=="" || user_nickname.value=="" ||
        user_phone.value=="" || user_email.value ==""){
            alert("입력하지 않은 칸이 존재합니다.");
            return;
        }

    if(!regName.test(user_name.value)){
        alert("이름은 한글만 입력 가능합니다.")
        user_name.value="";
        return;
    }else if(!regPhone.test(user_phone.value)){
        alert("전화번호 형식에 맞게 입력해주세요.")
        user_phone.value="";
        return;
    }else if(!regEmail.test(user_email.value)){
        alert("이메일 형식에 맞게 입력해주세요.");
        user_email.value="";
        return;
    }

    // 소셜 연동 계정은 패스워드 입력 없이 수정이 가능
    if(user_pw.value=="소셜 연동 계정입니다"){
        form.submit();
        return;
    }
    // 입력한 패스워드가 올바른지 DB에 검색해서 확인하는 코드
    let pw = user_pw.value;
    fetch("/users/checkPW?user_pw=" + pw, {
        method:"GET"
    })
    .then((res)=>{return res.text()})
    .then((res)=>{
        if(res>0){
           form.submit();
        }else{
            alert("해당 계정의 비밀번호를 정확히 입력해주세요.")
            user_pw.value="";
        }
    })
})