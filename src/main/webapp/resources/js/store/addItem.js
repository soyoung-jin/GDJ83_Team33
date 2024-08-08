const chname = document.getElementById("chname");
const category_num = document.getElementById("category_num");

category_num.addEventListener("change", ()=>{
    if(category_num.value == 0){
        chname.innerHTML="종족"
    } else {
        chname.innerHTML="무기 이름"
    }

})
