const category_amount = document.getElementById("category-amount");
const category_type = document.getElementById("category-type");
const list = document.getElementById("list");

category_type.addEventListener("change", ()=>{

     // 맨 처음 카테고리 선택시 아무런 작동도 안하게 하는 코드
    if(category_type.value == 0){  
        return;
    }
    // 비동기식은 해당 주소가 실제로 표기되지는 않기 때문에 기존 주소와 꼭 맞추지 않아도 된다.
   fetch("/users/tradeList/selectType?transaction_type=" + category_type.value, {
        method:"GET"
   })
   .then((res)=>{return res.text()})
   .then((res)=>{
          // 검색이 적용된 list 전체를 가져와서 해당 태그 안에 삽입해 줌
        list.innerHTML=res;
   })
})

category_amount.addEventListener("change", ()=>{

     fetch("/users/tradeList/selectAmount?transaction_amount=" + category_amount.value, {
          method:"GET"
     })
     .then((res)=>{return res.text()})
     .then((res)=>{
          list.innerHTML=res;
     })
})