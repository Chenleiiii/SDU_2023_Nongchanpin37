import { request } from '../utils/request'

// 增加单人贷款
export function addFinance(params) {
    return request({
        method: 'post',
        url: '/finance/add',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 增加组合贷款
export function addFinanceMulti(params) {
    return request({
        method: 'post',
        url: '/finance/addFinanceMulti',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 银行查询接口
export function selectBank(params) {
    return request({
        method: 'get',
        url: '/finance/selectbank',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 查询融资意向
export function selectIntention() {
    return request({
        method: 'get',
        url: '/finance/selectIntentionByName',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 添加融资意向
export function insertIntention(params) {
    return request({
        method: 'post',
        url: '/finance/insertIntentionByName',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 修改融资意向
export function updateIntention(params) {
    return request({
        method: 'put',
        url: '/finance/updateIntentionByName',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 删除融资意向
export function deleteIntention() {
    return request({
        method: 'delete',
        url: '/finance/deleteIntentionByName',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 查询推荐人
export function selectRecommned() {
    return request({
        method: 'get',
        url: '/finance/selectRecommendByName',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 查询单人贷款人信息
export function selectFinaceUser(bank_id) {
    return request({
        method: 'get',
        url: '/finance/selectFinaceUser/' + bank_id.bank_id,
        data: bank_id,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 查询组合贷款人信息
export function selectTwoUser(bank_id) {
    return request({
        method: 'get',
        url: '/finance/selectTwoUser/' + bank_id.bank_id,
        data: bank_id,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 查询贷款申请情况
export function selectByName() {
    return request({
        method: 'get',
        url: '/finance/selectByName/',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 修改贷款申请情况
export function updateById(params) {
    return request({
        method: 'put',
        url: '/finance/update/',
        data:params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 删除贷款申请
export function deleteById(financeId) {
    return request({
        method: 'delete',
        url: '/finance/delete/'+financeId.financeId,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}
// 根据id查询融资信息，信息回显
export function selectFinaceById(params) {
    return request({
        method: 'get',
        url: 'finance/selectById/' + params.id,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}