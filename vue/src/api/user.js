import { request } from '../utils/request'

// 用户登录
export function userLogin(params) {
    return request({
        method: 'post',
        url: 'user/login',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 用户注册
export function userRegister(params) {
    return request({
        method: 'post',
        url: 'user/add',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 用户登录之后，根据用户名展示个人基本信息
export function loginSelectByUsername(params) {
    return request({
        method: 'get',
        url: 'user/loginSelectByUsername',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 用户登录之后，根据用户名修改个人基本信息
export function loginUpdateByUsername(params) {
    return request({
        method: 'post',
        url: 'user/loginUpdateByUsername',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据用户名查询用户
export function selectUserByUsername(params) {
    return request({
        method: 'get',
        url: 'user/' + params.user_name,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据用户名删除用户
export function deleteUserByUsername(params) {
    return request({
        method: 'delete',
        url: 'user/' + params.user_name,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据用户名修改用户信息
export function updateUserByUsername(params) {
    return request({
        method: 'put',
        url: 'user/' + params.user_name,
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 分页查询所有用户
export function selectAllUserPage(params) {
    return request({
        method: 'get',
        url: 'user/search/' + params.pageNum,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 修改用户密码
export function updateUserPassword(params) {
    return request({
        method: 'post',
        url: 'user/loginUpdatePassword',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

