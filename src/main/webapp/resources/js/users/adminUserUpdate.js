const check = document.getElementById("check");
const user_id = document.getElementById("user_id");
const user_name = document.getElementById("user_name");
const user_nickname = document.getElementById("user_nickname");
const user_phone = document.getElementById("user_phone");
const user_email = document.getElementById("user_email");
const user_auth = document.getElementById("user_auth");
const form = document.getElementById("form");
const resign_zero = document.getElementById("resign_zero");
const resign_one = document.getElementById("resign_one");

const regName = /^(?=.*[가-힣])[가-힣]{2,}$/;
const regPhone = /^\d{2,3}-\d{3,4}-\d{4}$/;
const regEmail = /^[A-Za-z-0-9\-\.]+@[A-Za-z-0-9\-\.]+\.[A-Za-z-0-9]+$/;


// 회원 정보 수정시 정규식 검증 이벤트
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

    form.submit();
})

// 회원 계정 정지 이벤트
if(resign_zero != null){

    resign_zero.addEventListener("click", ()=>{
        
        let user_resign = 0;
        
        fetch("/admin/userResign?user_id=" + user_id.value + "&user_resign=" + user_resign, {
            method:"GET"
        })
        .then((res)=>{return res.text()})
        .then((res)=>{
            if(res>0){
                alert("회원 정지가 완료되었습니다.");
                location.href="/admin/userDetail?user_id=" + user_id.value;
            }
        })
    })
}
    
// 회원 계정 복구 이벤트

if(resign_one != null){
resign_one.addEventListener("click", ()=>{

    let user_resign = 1;

    fetch("/admin/userResign?user_id=" + user_id.value + "&user_resign=" + user_resign, {
        method:"GET"
    })
    .then((res)=>{return res.text()})
    .then((res)=>{
        if(res>0){
            alert("회원 복구가 완료되었습니다.");
            location.href="/admin/userDetail?user_id=" + user_id.value;
        }
    })
})
}
