import { request } from '../utils/request'

// 根据用户名查询问答  kind：普通用户：questioner；专家：expert
export function selectQuestionByUser(params) {
  return request({
      method: 'get',
      url: `/question/selectByKind/` + params.role,
      headers: {
          'Authorization': window.localStorage.token,
      },
      // data:params看土壤特点，一般沙土为一周一次
  })
}

// 查询问答根据id
export function selectQuestionByUserId(params) {
  return request({
      method: 'get',
      url: `/question/selectId/{params.id}`,
      headers: {
          'Authorization': window.localStorage.token,
      },
      // data:params
  })
}

// 根据id修改
export function reviseQuestionByUserId(params) {
  return request({
      method: 'put',
      url: '/question/update',
      headers: {
          'Authorization': window.localStorage.token,
      },
      data:params
  })
}

// 根据id删除
export function delQuestionByUserId(params) {
  return request({
      method: 'delete',
      url: `/question/delete/${params.id}`,
      headers: {
          'Authorization': window.localStorage.token,
      },
      data:params
  })
}

// 根据用户名查询预约  kind：普通用户：questioner；专家：expert
export function selectAppointByUser(params) {
  return request({
      method: 'get',
      url: `/reserve/selectByKind/${params.type}`,
      headers: {
          'Authorization': window.localStorage.token,
      },
      // data:params
  })
}

// 根据id修改预约
export function reviseAppointByUserId(params) {
  return request({
      method: 'put',
      url: '/reserve/update',
      headers: {
          'Authorization': window.localStorage.token,
      },
      data:params
  })
}

// 根据id删除预约
export function delAppointByUserId(params) {
  return request({
      method: 'delete',
      url: `/reserve/delete/${params.id}`,
      headers: {
          'Authorization': window.localStorage.token,
      },
      data:params
  })
}