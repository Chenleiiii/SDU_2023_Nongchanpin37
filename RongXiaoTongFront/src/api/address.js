import { request } from '../utils/request'

// 添加地址
export function addAddress(params) {
    return request({
        method: 'post',
        url: '/address/add',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 默认地址信息更新
export function defaultAddressInfoUpdate(params) {
    return request({
        method: 'post',
        url: 'address/defaultAddressInfoUpdate',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据登录用户名查询默认地址
export function selectDefaultByOwnName(params) {
    return request({
        method: 'get',
        url: 'address/selectDefaultByOwnName',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据id删除地址
export function deleteAddressById(params) {
    return request({
        method: 'delete',
        url: 'address/delete/' + params.addressId,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据登陆用户名查询所有地址
export function selectAllAddressByUsername(params) {
    return request({
        method: 'get',
        url: '/address/selectByOwnName',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}







