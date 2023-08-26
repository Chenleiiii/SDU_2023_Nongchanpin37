import { request } from '../utils/request'

//下架
export function takeDown(params) {
    return request({
        method: 'put',
        url: 'order/takeDownOrder/'+params.item,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
//上架
export function takeUp(params) {
    return request({
        method: 'put',
        url: 'order/takeUpOrder/'+params.item,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 添加订单
export function addOrder(params) {
    return request({
        method: 'post',
        url: 'order',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 分页查询所有货源（商品）订单
export function selectGoodsPage(params) {
    if(params.keys == ""){
        return request({
            method: 'get',
            url: 'order/goods/' + params.pageNum,
            // params: params,
        })
    }else{
        return request({
            method: 'get',
            url: 'order/searchGoodsByKeys/' + params.keys + '/' + params.pageNum,
            // params: params,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })
    }
}
// 分页查询所有货源（商品）订单
export function selectAllPage(params) {
    if (params.keys == "") {
        return request({
            method: 'get',
            url: 'order/All/' +params.pageNum,
            // params: params,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })
    } else { 
        return request({
            method: 'get',
            url: 'order/searchAllByKeys/' + params.keys + '/' + params.pageNum,
            // params: params,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })
    }
}


// 分页查询所有需求订单
export function selectNeedsPage(params) {
    if(params.keys == ""){
        return request({
            method: 'get',
            url: 'order/needs/' + params.pageNum,
            // params: params,,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })
    }else{
        return request({
            method: 'get',
            url: 'order/searchNeedsByKeys/' + params.keys + '/' + params.pageNum,
            // params: params,,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })
    }
}

//根据id查询订单
export function selectOrderById(params) {
    return request({
        method: 'get',
        url: 'order/selectById/' + params.order_id,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

//根据id修改订单
export function updateOrderById(params) {
    return request({
        method: 'put',
        url: 'order/' + params.order_id,
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据id删除订单
export function deleteOrderById(params) {
    return request({
        method: 'delete',
        url: 'order/' + params.order_id,
        params: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

//根据用户名+订单类型查询订单
export function selectOrderByUsernameAndType(params) {
    if(params.ctype=='goods'&&params.keys!==''){ 
        return request({
            method: 'get',
            url: `/order/searchMyGoodsByKeys/${params.keys}/${params.pageNum}`,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })       
    }else if(params.ctype=='needs'&&params.keys!==''){
        return request({
            method: 'get',
            url: `/order/searchMyNeedsByKeys/${params.keys}/${params.pageNum}`,
            headers: {
                'Authorization': window.localStorage.token,
            },
        }) 
    }else{
        return request({
            method: 'get',
            url: 'order/search/' + params.ctype + '/' + params.pageNum,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })
    }
}

// //根据种类，用户名查询个人商品模糊查询
// export function selectOrderByKeys(params) {
//     return request({
//         method: 'get',
//         url: 'order/search/' + params.ctype + '/' + params.pageNum,
//         headers: {
//             'Authorization': window.localStorage.token,
//         },
//     })
// }

// 根据登陆用户查询我买的订单
export function selectBuyByUserName(params) {
    return request({
        method: 'get',
        url: 'order/selectBuys',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据登陆用户查询我买的订单
export function selectOwnByName(params) {
    return request({
        method: 'get',
        url: 'user/'  + params.own_name,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据登录用户查询我卖的订单
export function selectSellByUserName(params) {
    return request({
        method: 'get',
        url: 'order/selectSells',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 检索问答接口
export function selectQuestions(params) {
    if(params.keys===''){
        return request({
            method: 'get',
            url: `/question/findAllQues/${params.pageNum}`,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })
    }else{
        return request({
            method: 'get',
            url: `/question/findPageQues/${params.keys}/${params.pageNum}`,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })
    }
}

// 检索专家接口
export function selectExpert(params) {
    if(params.keys===''){
        return request({
            method: 'get',
            url: `/question/findExpert/${params.pageNum}`,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })
    }else{
        return request({
            method: 'get',
            url: `/question/findExpertByKeys/${params.keys}/${params.pageNum}`,
            headers: {
                'Authorization': window.localStorage.token,
            },
        })
    }
}
// 问答详情
export function questionDetail(params) {
    return request({
        method: 'get',
        url: `/question/selectId/${params.id}`,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
//去提问
export function addQuestion(params) {
    return request({
        method: 'post',
        url: `/question/add`,
        headers: {
            'Authorization': window.localStorage.token,
        },
        data:params
    })
}

//去预约
export function addReserve(params) {
    return request({
        method: 'post',
        url: `/reserve/add`,
        headers: {
            'Authorization': window.localStorage.token,
        },
        data:params
    })
}

