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
    console.log("가격은 "+resultPrice)
    return resultPrice;
}


//카카오 결제 취소 함수
async function kakaoDel() {
    uuid = "payment-ee489c7b-9abe-4e98-b34c-b0241234d391";
    const del = await fetch(`https://api.portone.io/payments/`+uuid+`/cancel`,{ 
        method: 'post',
        headers: {Authorization: `PortOne i68oGkSudVRHtsQtbxZitbS7DPq99kDGH6xS2tz5l9W7w8ppV6xKcAioepMEyyYiW2Ae0mUGZ0NgUguK`, headers: {'Content-Type': 'application/json'}},
        body: '{"reason":"그냥"}'
    },);
    if (!del.ok)
        throw new Error(`del:`+ await del.json());
    const d = await del.json();

    console.log(d);
    
    return d.cancellation.status;
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
        storeId: "store-0db2908e-d8b1-4658-a473-043843f02a63",
        // 채널 키 설정
        channelKey: "channel-key-a30ed3c2-b963-42d9-a899-949483621dc4",
        paymentId: `payment-`+uuid,
        orderName: itemName[0].getAttribute("data-iname")+"외 "+(itemName.length-1)+"개",
        totalAmount: totalPrice(),
        currency: "CURRENCY_KRW",
        payMethod: "EASY_PAY",
    });
    console.log("결제 번호: "+response.paymentId)
    console.log("오류 내용: "+response.code)

    if (response.code != null) {
        // 오류 발생
        return alert(response.message);
    };
    
    //포트원 결제내역 단건조회 API 호출
    const paymentResponse = await fetch(`https://api.portone.io/payments/payment-`+uuid,{
        headers: { Authorization: `PortOne i68oGkSudVRHtsQtbxZitbS7DPq99kDGH6xS2tz5l9W7w8ppV6xKcAioepMEyyYiW2Ae0mUGZ0NgUguK`} },
    )
    
    if (!paymentResponse.ok)
        throw new Error(`paymentResponse:`+ await paymentResponse.json());
    
    const payment = await paymentResponse.json();
    
    console.log("결제 단건 조회 json:")
    console.log(payment)
        
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
                    })
                    
                    if(itemName[i].getAttribute("data-wnum")){
                        fetch("/store/deleteWishList?wishlist_num="+itemName[i].getAttribute("data-wnum"),{
                            method:"get"
                        }).then(r=>{r.text})
                    }

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
