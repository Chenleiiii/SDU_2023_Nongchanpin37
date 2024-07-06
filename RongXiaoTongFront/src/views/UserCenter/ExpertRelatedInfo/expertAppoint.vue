<!--专家问答-->
<template>
  <div class="expert-appoint-container">
    <div v-for="(item,index) in appointArray" :key="index" class="appoint-item">
      <div class="appoint-content">
        <div class="title">{{item.plantName}}</div>
        <div class="content">{{item.plantDetail}}</div>
        <div class="item-container">
          <div class="item-content marginR30" v-if="role==='expert'">
            <div class="item-title">咨询者：</div>
            <div class="item-text">{{item.questioner}}</div>
          </div>
          <div class="item-content marginR30" v-if="role==='expert'">
            <div class="item-title">咨询者联系方式：</div>
            <div class="item-text">{{item.phone}}</div>
          </div>
          <div class="item-content marginR30" v-if="role==='questioner'">
            <div class="item-title">专家姓名：</div>
            <span class="item-text">{{item.expertName}}</span>
          </div>
        </div>
        <div class="item-container">
          <div class="item-content marginR30">
            <div class="item-title">作物条件：</div>
            <span class="item-text">{{item.plantCondition}}</span>
          </div>
          <div class="item-content marginR30">
            <div class="item-title">土壤条件：</div>
            <div class="item-text" :title="item.soilCondition">{{item.soilCondition}}</div>
          </div>
          <div class="item-content marginR30">
            <div class="item-title">面积：</div>
            <div class="item-text">{{item.area}}亩</div>
          </div>
          <el-tag style="position:relative;left:360px" :type="item.status === 0 ? 'danger':'success'" size="mini">{{item.status === 0 ? '未回答' :'已回答'}}</el-tag>
        </div>
      </div>
      <div class="appoint-btn">
        <div class="btn-text" @click="handleDetail(item)">详情</div>
        <div class="btn-text" @click="handleEdit(item)">修改</div>
        <div class="btn-text" @click="delAppoint(item)">删除</div>
      </div>
    </div>
    <el-dialog title="详情" :visible.sync="showDetail" width="600px" :before-close="detailClose">
      <div class="detail-content">
        <div class="detail-item">
          <div class="item-title">种植作物：</div>
          <div class="item-content">{{detailObj.plantName}}</div>
        </div>
        <div class="detail-item">
          <div class="item-title">作物详细信息：</div>
          <div class="item-content">{{detailObj.plantDetail}}</div>
        </div>
        <div class="detail-item">
          <div class="item-title">地址：</div>
          <div class="item-content">{{detailObj.address}}</div>
        </div>
         <div class="detail-item">
          <div class="item-title">土壤条件：</div>
          <div class="item-content">{{detailObj.soilCondition}}</div>
        </div>
        <div class="detail-item">
          <div class="item-title">面积：</div>
          <div class="item-content">{{detailObj.area}}</div>
        </div>
         <div class="detail-item">
          <div class="item-title">作物条件：</div>
          <div class="item-content">{{detailObj.plantCondition}}</div>
        </div>
         <div class="detail-item" v-if="role==='expert'">
          <div class="item-title">联系方式：</div>
          <div class="item-content">{{detailObj.phone}}</div>
        </div>
         <div class="detail-item" v-if="role==='expert'">
          <div class="item-title">提问者：</div>
          <div class="item-content">{{detailObj.questioner}}</div>
        </div>
        <div class="detail-item">
          <div class="item-title">问题状态：</div>
          <el-tag type="danger" size="mini">{{detailObj.status === 0 ? '未回答' :'已回答'}}</el-tag>
        </div>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="showDetail = false">取 消</el-button>
        <el-button type="primary" @click="showDetail = false">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog title="修改" :visible.sync="dialogVisible" width="650px" :before-close="closeRevise">
      <div class="detail-content">
        <div class="detail-item">
          <div class="item-title">种植作物：</div>
          <div class="item-content">{{detailObj.plantName}}</div>
        </div>
        <div class="detail-item">
          <div class="item-title">作物详细信息：</div>
          <div class="item-content">{{detailObj.plantDetail}}</div>
        </div>
        <div class="detail-item">
          <div class="item-title">地址：</div>
          <div class="item-content">{{detailObj.address}}</div>
        </div>
         <div class="detail-item">
          <div class="item-title">土壤条件：</div>
          <div class="item-content">{{detailObj.soilCondition}}</div>
        </div>
        <div class="detail-item">
          <div class="item-title">面积：</div>
          <div class="item-content">{{detailObj.area}}</div>
        </div>
        <div class="detail-item">
          <div class="item-title">作物条件：</div>
          <div class="item-content">{{detailObj.plantCondition}}</div>
        </div>
         <div class="detail-item">
          <div class="item-title">联系方式：</div>
          <div class="item-content">{{detailObj.phone}}</div>
        </div>
         <div class="detail-item">
          <div class="item-title">提问者：</div>
          <div class="item-content">{{detailObj.questioner}}</div>
        </div>
        <div class="detail-item">
          <div class="item-title">问题状态：</div>
          <el-tag type="danger" size="mini">{{detailObj.status === 0 ? '未回答' :'已回答'}}</el-tag>
        </div>
        <el-form ref="form" :model="detailObj" label-width="60px">
          <el-form-item label="回答：">
            <el-input type="textarea" v-model="detailObj.answer"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeRevise">取 消</el-button>
        <el-button type="primary" @click="submitRevise">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { selectAppointByUser,reviseAppointByUserId,delAppointByUserId } from '../../../api/question.js'

export default {
  data(){
    return{
      appointArray:[],
      role:"",
      showDetail: false,
      dialogVisible: false,
      detailObj:{
        title:'',
        expertName:'',
        questioner:'',
        status:''
      }
    }
  },
  methods:{
    getData(){
      this.role =  this.$store.getters.isExpert?'expert':'questioner'

      // kind：普通用户：questioner；专家：expert
      selectAppointByUser({type:this.role}).then(res => {
        console.log('rererer',res)
        this.appointArray = res.data
      }).catch(err=>{
        console.log(err)
      })
    },
    delAppoint(item){
      this.$confirm('确认删除该行信息？', '删除', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        delAppointByUserId({id:item.id}).then(res=>{
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          this.getData()
        }).catch(err=>{
          console.log(err)
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    handleDetail(item){
      this.showDetail = true
      this.detailObj = Object.assign({},{...item})
    },
    detailClose(){
      this.showDetail = false
    },
    handleEdit(item){
      this.dialogVisible = true
      this.detailObj = Object.assign({},{...item})
    },
    closeRevise(){
      this.dialogVisible = false
    },
    submitRevise(){
      this.detailObj.status = 1
      reviseAppointByUserId(this.detailObj).then(res => {
        this.$message.success('修改成功！')
        this.dialogVisible = false
        this.getData()
      }).catch(err=>{
        console.log(err)
      })
    }
  },
  mounted(){
    this.$store.commit("updateUserActiveIndex", "4-2");
    this.getData()
  }
}
</script>

<style lang="less" scoped>
.expert-appoint-container{
  width: 900px;
  min-height: 100%;
  // padding: 10px 20px;
  background: #fff;
  .appoint-item{
    border:1px solid #f2f2f2;
    border-radius: 6px;
    padding: 10px 20px;
    margin: 10px 20px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    .appoint-content{
      width: 650px;
      .title{
        font-weight: bold;
        font-size: 18px;
        line-height: 30px;
        height: 30px;
      }
      .content{
        line-height: 25px;
        height: auto;
        word-break: break-all;
      }
      .item-container{
        display: flex;
        flex-direction: row;
        justify-content: flex-start;
        align-items: center;
        font-size: 12px;
        line-height: 20px;
        .item-content{
          display: flex;
          flex-direction: row;
          justify-content: flex-start;
          align-items: center;
        }
        .item-title{
          max-width: 100px;
        }
      }
      .marginR30{
        margin-right: 30px;
      }
      .item-text{
        color: #666;
        max-width: 200px;
        /*超出的部分隐藏*/
        overflow: hidden;
        /*文字用省略号替代超出的部分*/
        text-overflow: ellipsis;
        /*弹性伸缩盒子模型显示*/
        display: -webkit-box;
        /*限制在一个块元素显示文本的行数*/
        -webkit-line-clamp: 1;
        /*设置或检索伸缩盒对象的子元素排列方式*/
        -webkit-box-orient: vertical;
        word-break: break-all;
      }
    }
    .appoint-btn{
      display: flex;
      .btn-text{
        height: 25px;
        cursor: pointer;
        margin-right: 10px;
        color: #67C23A;
        &:hover{
          color: #035D1C;
          text-decoration: underline;
        }
      }
    }
  }
  .detail-content{
    max-height: 500px;
    height: auto;
    overflow-y: auto;
  }
  .detail-item{
    display: flex;
    line-height: 30px;
    .item-content{
      line-height: 30px;
      height: auto;
      width: 480px;
      display: flex;
    }
    .item-title{
      width: 150px;
      height: 30px;
      font-weight: bold;
      color: #333;
    }
  }
}
</style>
