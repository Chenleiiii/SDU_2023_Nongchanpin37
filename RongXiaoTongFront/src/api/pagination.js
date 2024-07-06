import { request } from '../utils/request'

// 分页查询
export function pagination(params) {
    return request({
        method: 'get',
        url: params.cUrl + params.pageNum,
        // params: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}