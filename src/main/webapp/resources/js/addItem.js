const wpdiv = document.getElementById("wpdiv")
const category = document.getElementById("category")
const weapon_description = document.getElementById("weapon_description")

//분류 값 변경시 함수 실행
category.addEventListener("change",()=>{
    changeCategory();
})


//무기 설명란의 style 속성 display: none; 대입하면 div 자체가 사라짐
function changeCategory (){
    //category.value==1 > 무기 입력하는 화면이기때문에 무기 설명란 보여야함
    if(category.value==1){
        wpdiv.style=""
    } else {
        wpdiv.style="display: none;"
    }
}

//무기 추가시말고 무기 수정할 때 필요함
changeCategory();

