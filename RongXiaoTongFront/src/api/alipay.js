import { request } from '../utils/request'

// 支付路经
export function alipayRoad(params) {
    return request({
        method: 'post',
        url: `/cart/commitOrder/${params.addId}/${params.tMoney}`,
        data: params.shoppingModelList,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 查询默认购物车
export function defaultCart(params) {
    return request({
        method: 'get',
        url: '/address/selectDefaultByOwnName',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
