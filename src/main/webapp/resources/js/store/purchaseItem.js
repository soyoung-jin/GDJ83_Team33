const kakaobtn = document.getElementById("kakaobtn")
const kakaodelbtn = document.getElementById("kakaodelbtn")
const itemPrice = document.getElementsByClassName("itemPrice")
const itemName = document.getElementsByClassName("itemName")

let uuid = "";
let resultPrice = 0

const kakaostatus = '';

//제품들 총 가격 계산
function totalPrice(){
    resultPrice = 0
    for(i=0;i<itemPrice.length;i++){
        resultPrice = resultPrice+Number(itemPrice[i].id)
    }
    return resultPrice;
}

//카카오 결제 버튼
kakaobtn.addEventListener("click",()=>{
    kakaoRequestPayment();
   
});
    

//카카오 결제창 요청 함수
async function kakaoRequestPayment() {
    let orderPre = new Date().getTime()
    let orderBack = Math.floor(Math.random() *1000000)

    uuid = orderPre+"-"+orderBack;
    
    const response = await PortOne.requestPayment({
        // Store ID 설정
        storeId: "",
        // 채널 키 설정
        channelKey: "",
        paymentId: `payment-`+uuid,
        orderName: itemName[0].getAttribute("data-iname")+"외 "+(itemName.length-1)+"개",
        totalAmount: totalPrice(),
        currency: "CURRENCY_KRW",
        payMethod: "EASY_PAY",
    });

    if (response.code != null) {
        // 오류 발생
        return alert(response.message);
    };
    
    //포트원 결제내역 단건조회 API 호출
    const paymentResponse = await fetch(`https://api.portone.io/payments/payment-`+uuid,{
        headers: { Authorization: ``} },
    )
    
    if (!paymentResponse.ok)
        throw new Error(`paymentResponse:`+ await paymentResponse.json());
    
    const payment = await paymentResponse.json();
    
        
    // 조회내역의 금액과 요청시의 금액 비교
    if(payment.amount.total == resultPrice){
        switch (payment.status) {
            //결제성공 시
            case "PAID": {
                //DB에 저장, 위시리스트 삭제
                for(i=0;i<itemPrice.length;i++){
                    fetch("/store/purchaseComplete", {
                        method: "POST",
                        headers: { "Content-Type": "application/json" },
                        // paymentId와 주문 정보를 서버에 전달합니다
                        body: JSON.stringify({
                            item_num: itemName[i].id,
                            transaction_amount: itemPrice[i].id,
                            transaction_order: payment.id,
                        }),
                    }).catch(()=>{})
                    
                    // if(itemName[i].getAttribute("data-wnum")){
                    //     fetch("/store/deleteWishList?wishlist_num="+itemName[i].getAttribute("data-wnum"),{
                    //         method:"get"
                    //     }).catch(()=>{})
                    // }

                }
                alert("결제 성공")
                location.href="/store/purchaseFinish"
                break;
            }
            default : {
                alert("결제 실패")
                break;
            }
        }
    }

}
