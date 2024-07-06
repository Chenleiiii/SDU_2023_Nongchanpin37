<!--专家问答-->
<template>
  <div class="expert-question-container">
    <div v-for="(item,index) in questionArray" :key="index" class="question-item">
      <div class="question-content">
        <div class="title">{{item.title}}</div>
        <div class="content">{{item.question}}</div>
        <div class="item-container">
          <div class="item-content marginR30" v-if="role==='expert'">提问者：<span class="item-text">{{item.questioner}}</span> </div>
          <div class="item-content marginR30" v-if="role==='expert'">提问者联系方式：<span class="item-text">{{item.phone}}</span> </div>
          <div class="item-content marginR30" v-if="role==='questioner'">专家姓名：<span class="item-text">{{item.expertName}}</span></div>
          <el-tag :type="item.status === 0 ? 'danger':'success'" size="mini">{{item.status === 0 ? '未回答' :'已回答'}}</el-tag>
        </div>
      </div>
      <div class="question-btn">
        <div class="btn-text" @click="handleDetail(item)">详情</div>
        <div class="btn-text" @click="handleEdit(item)" v-if="role==='questioner'">修改</div>
        <div class="btn-text" @click="handleEdit(item)" v-if="role==='expert'">回答</div>
        <div class="btn-text" @click="delQuestion(item)">删除</div>
      </div>
    </div>
    <el-dialog title="详情" :visible.sync="showDetail" width="600px" :before-close="detailClose">
      <div>
        <div class="detail-item">
          <div class="item-title">问题标题：</div>
          <div class="item-content">{{detailObj.title}}</div>
        </div>
        <div class="detail-item">
          <div class="item-title">问题内容：</div>
          <div class="item-content">{{detailObj.question}}</div>
        </div>
        <div class="detail-item" v-if="role==='questioner'">
          <div class="item-title">专家姓名：</div>
          <div class="item-content">{{detailObj.expertName}}</div>
        </div>
        <!-- <div class="detail-item">
          <div class="item-title">提问者：</div>
          <div class="item-content">{{detailObj.questioner}}</div>
        </div> -->
        <div class="detail-item">
          <div class="item-title">问题状态：</div>
          <el-tag type="danger" size="mini">{{detailObj.status === 0 ? '未回答' :'已回答'}}</el-tag>
        </div>
      </div>
      <span slot="footer" class="dialog-footer">
        <!-- <el-button @click="showDetail = false">取 消</el-button> -->
        <el-button type="primary" @click="showDetail = false">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog :title="title" :visible.sync="dialogVisible" width="650px" :before-close="closeRevise">
      <div>
        <div class="detail-item">
          <div class="item-title">问题标题：</div>
          <div class="item-content">{{detailObj.title}}</div>
        </div>
        <!-- 专家不能改问题内容 -->
        <div class="detail-item" v-if="role==='expert'||detailObj.status === 1">
          <div class="item-title">内容：</div>
          <div class="item-content">{{detailObj.question}}</div>
        </div>
        <!-- 提问者可以改问题内容 -->
        <el-form ref="form" :model="detailObj" label-width="60px" v-if="role==='questioner'&&detailObj.status === 0">
          <el-form-item label="内容：">
            <el-input type="textarea" v-model="detailObj.question"></el-input>
          </el-form-item>
        </el-form>

        <div class="detail-item" v-if="role==='questioner'">
          <div class="item-title">回答：</div>
          <div class="item-content">{{detailObj.answer}}</div>
        </div>
        <el-form ref="form" :model="detailObj" label-width="60px" v-if="role==='expert'">
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
import { selectQuestionByUser,reviseQuestionByUserId,delQuestionByUserId } from '../../../api/question.js'

export default {
  data(){
    return{
      questionArray:[],
      showDetail: false,
      dialogVisible: false,
      role:"",
      title:"",
      detailObj:{
        title:'',
        question:'',
        answer:'',
        address:'',
        area:'',
        expertName:'',
        plantCondition:'',
        plantDetail:'',
        plantName:'',
        questioner:'',
        soilCondition:'',
        status:1
      }
    }
  },
  methods:{
    getData(){
      this.role = this.$store.getters.isExpert?'expert':'questioner'
      console.log('role',this.role)
      // kind：普通用户：questioner；专家：expert
      selectQuestionByUser({role:this.role}).then(res => {
        console.log('rererer',res)
        this.questionArray = res.data
      }).catch(err=>{
        console.log(err)
      })
    },
    delQuestion(item){
      this.$confirm('确认删除该行信息？', '删除', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        delQuestionByUserId({id:item.id}).then(res=>{
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
      if(this.role === 'questioner'){
        this.title = "修改";
      }else{
        this.title = "回答";
      }
      this.dialogVisible = true
      this.detailObj = Object.assign({},{...item})
    },
    closeRevise(){
      this.dialogVisible = false
    },
    submitRevise(){
      if(this.role === 'expert'){
        this.detailObj.status = 1
      }else{
        this.detailObj.status = 0
      }

      reviseQuestionByUserId(this.detailObj).then(res => {
        this.$message.success('修改成功！')
        this.dialogVisible = false
        this.getData()
      }).catch(err=>{
        console.log(err)
      })
    }
  },
  mounted(){
    this.$store.commit("updateUserActiveIndex", "4-1");
    this.getData()
  }
}
</script>

<style lang="less" scoped>
.expert-question-container{
  width: 900px;
  min-height: 100%;
  // padding: 10px 20px;
  background: #fff;
  .question-item{
    border:1px solid #f2f2f2;
    border-radius: 6px;
    padding: 10px 20px;
    margin: 10px 20px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    .question-content{
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
      }
      .marginR30{
        margin-right: 30px;
      }
      .item-text{
        color: #666;
      }
    }
    .question-btn{
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
  .detail-item{
    display: flex;
    line-height: 30px;
    .item-content{
      line-height: 30px;
      height: auto;
      width: 480px;
    }
    .item-title{
      width: 80px;
      height: 30px;
      font-weight: bold;
      color: #333;
    }
  }
}
</style>
