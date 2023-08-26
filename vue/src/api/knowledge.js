import { request } from '../utils/request'

// 添加知识
export function addKnowledge(params) {
    return request({
        method: 'post',
        url: 'knowledge',
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 分页查询所有知识
export function selectKnowledgesPage(params) {
    return request({
        method: 'get',
        url: 'knowledge/' + params.pageNum,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

//根据id修改知识
export function updateKnowledgeById(params) {
    return request({
        method: 'put',
        url: 'knowledge/' + params.knowledgeId,
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据id删除知识
export function deleteKnowledgeById(params) {
    return request({
        method: 'delete',
        url: 'knowledge/' + params.knowledgeId,
        params: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据id查询知识信息
export function selectKnowledgeById(params) {
    return request({
        method: 'get',
        url: 'knowledge/selectById/' + params.knowledgeId,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据登录用户查询知识 
export function selectKnowledgeByUsername(params) {
    return request({
        method: 'get',
        url: 'knowledge/selectByUsername/',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据登录用户查询知识 
export function selectComment(params) {
    return request({
        method: 'get',
        url: `/knowledge/selectByKnowledge/${params.knowledgeId}`,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 增加评论
export function addComment(params) {
    return request({
        method: 'post',
        url: `/knowledge/addByKnowledge/${params.knowledgeId}/${params.content}`,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}