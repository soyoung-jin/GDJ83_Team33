const category = document.getElementById("category");
const itemListdiv = document.getElementById("itemListdiv");
const option = document.getElementById("option");
const searchbtn = document.getElementById("searchbtn");
const getImage = document.getElementById("getImage");
const modalContents =document.getElementById("modalContents");
const modalBtn = document.getElementById("modalBtn");

let search = document.getElementById("search").value;
let kind = document.getElementById("kind").value;
let page = 1;

//디테일 모달 요청
function getItemNum(itemnum){

    fetch("itemDetail?item_num="+itemnum,{
        method:"get"
    }).then(r=>r.text())
    .then(r=>{
        modalContents.innerHTML=r

        modalBtn.click()
    })

}

//결제 버튼
itemListdiv.addEventListener("click", (e)=>{

    if(e.target.classList.contains("purchaseItem")){
        let itemnum= e.target.getAttribute("data-inum");

        e.target.href="purchaseItem?ar="+itemnum;
    }

})
 
//리스트 불러오는 함수
function getList(category_num, page, kind, search){
    fetch("./itemListRefresh?category_num="+category_num+"&page="+page+"&kind="+kind+"&search="+search,{
        method:"get"
    }).then((res)=>res.text())
    .then((res)=>{
        
        itemListdiv.innerHTML=res

    }).catch(()=>{alert("리스트 조회 실패")})
}

//페이징
itemListdiv.addEventListener("click", (e)=>{

    if(e.target.classList.contains("pagenum")){
        page = e.target.getAttribute("data-num");
        getList(category.value, page, kind, search)
        
    }

})

//검색 
searchbtn.addEventListener("click",()=>{

    search = document.getElementById("search").value;
    kind = document.getElementById("kind").value;
    page=1

    getList(category.value,page,kind,search)

})

category.addEventListener("change", ()=>{
    if(category.value == 0 ){
        option.innerHTML = "종족"
    } else {
        option.innerHTML = "무기 이름"
    }
})

//위시리스트
itemListdiv.addEventListener("click",(e)=>{
    if(e.target.classList.contains("addwish")){

        let item_num = e.target.getAttribute("data-inum")

        fetch("addWishList?item_num="+item_num,{
            method:"GET"
        })
        .then(r=>r.text())
        .then(r=>{

            if(r>0){
                let check = confirm("찜목록으로 가시겠습니까?")
    
                if(check){
                    location.href="getWishList"
                }
            } else if(r<0){
                alert ("로그인 ㄱㄱ")
            } else {
                alert ("추가 실패")
            }

        }).catch(()=>{alert("추가 실패")})

    }
})


