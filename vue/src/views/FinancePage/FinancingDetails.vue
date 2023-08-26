<template>
  <div class="details-box2">
    <div class="title">
      <strong>{{ FinaceUserDetails.bankName }}</strong>
    </div>
    <div class="introduce">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{ FinaceUserDetails.introduce }}
    </div>

    <div class="title">
      <br />
      <strong>请选择个人贷款还是组合贷款</strong><br />
      <el-button type="success" plain round @click="individual" v-if="Already === false"
        >个人贷款</el-button
      >
      <el-button type="success" plain round @click="combination" v-if="Already === false"
        >组合贷款</el-button
      >
      <el-button type="warning" v-if="Already" disabled>已申请贷款</el-button>
    </div>

    <!--单人贷款 -->
    <el-dialog
      :title="title"
      :visible.sync="showIndividual"
      width="580px"
      :before-close="closeIndividual"
    >
      <el-form
        v-model="FinaceUserDetails"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="姓名：" prop="name">
          <el-input v-model="FinaceUserDetails.name"></el-input>
        </el-form-item>
        <el-form-item label="融资额度：" prop="money">
          <el-input v-model="FinaceUserDetails.money"></el-input>
        </el-form-item>
        <el-form-item label="利息：" prop="rate">
          <!-- <el-input v-model="FinaceUserDetails.rate"></el-input> -->
          {{ FinaceUserDetails.rate }}
        </el-form-item>
        <el-form-item label="意向借款期：" prop="repayment">
          <el-select v-model="value" placeholder="意向借款期：">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="联系方式：" prop="phone">
          <el-input v-model="FinaceUserDetails.phone"></el-input>
        </el-form-item>
        <el-form-item label="身份证号：" prop="idNum">
          <el-input v-model="FinaceUserDetails.idNum"></el-input>
        </el-form-item>
        <el-form-item label="上传材料：" prop="photo">
          <el-upload
            class="upload-demo"
            drag
            :action="upurl"
            multiple
        :headers="upheaders"
        :on-change="handleChange"
        :on-success="handleSuccess"
        :file-list="fileList"
        ref="upload"
          >
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">
              将文件拖到此处，或<em>点击上传</em>
            </div>
          </el-upload>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeIndividual">取 消</el-button>
        <el-button type="success" @click="handleApplyOne">申请</el-button>
      </span>
    </el-dialog>

    <!-- 组合贷款 -->
    <el-dialog
      :title="title"
      :visible.sync="showCombination"
      width="580px"
      :before-close="closeCombination"
    >
      <el-form
        v-model="UserDetailsMulti"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <!-- 综合信息 -->
        <strong style="color: green">申请融资信息：</strong>
        <el-form-item label="融资额度：" prop="money">
          <el-input v-model="UserDetailsMulti.money"></el-input>
        </el-form-item>
        <el-form-item label="利息：" prop="rate">
          <!-- <el-input v-model="UserDetailsMulti.rate"></el-input> -->
          {{ UserDetailsMulti.rate }}
        </el-form-item>
        <el-form-item label="意向借款期：" prop="repaymentPeriod">
          <el-select v-model="value" placeholder="意向借款期：">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <!-- 用户1 -->
        <strong style="color: green">用户1：</strong>
        <el-form-item label="姓名：" prop="realName">
          <el-input v-model="UserDetailsMulti.realName"></el-input>
        </el-form-item>
        <el-form-item label="联系方式：" prop="phone">
          <el-input v-model="UserDetailsMulti.phone"></el-input>
        </el-form-item>
        <el-form-item label="身份证号：" prop="idNum">
          <el-input v-model="UserDetailsMulti.idNum"></el-input>
        </el-form-item>
        <!-- 用户2 -->
        <strong style="color: green">用户2：</strong>
        <el-form-item label="姓名：" prop="combinationName1">
          <el-input v-model="UserDetailsMulti.combinationName1"></el-input>
        </el-form-item>
        <el-form-item label="联系方式：" prop="combinationPhone1">
          <el-input v-model="UserDetailsMulti.combinationPhone1"></el-input>
        </el-form-item>
        <el-form-item label="身份证号：" prop="combinationIdnum1">
          <el-input v-model="UserDetailsMulti.combinationIdnum1"></el-input>
        </el-form-item>

        <!-- 用户3 -->
        <strong style="color: green">用户3：</strong>
        <el-form-item label="姓名：" prop="combinationName2">
          <el-input v-model="UserDetailsMulti.combinationName2"></el-input>
        </el-form-item>
        <el-form-item label="联系方式：" prop="combinationPhone2">
          <el-input v-model="UserDetailsMulti.combinationPhone2"></el-input>
        </el-form-item>
        <el-form-item label="身份证号：" prop="combinationIdnum2">
          <el-input v-model="UserDetailsMulti.combinationIdnum2"></el-input>
        </el-form-item>
        <el-form-item label="上传材料：" prop="photo">
          <el-upload
            class="upload-demo"
            drag
            :action="upurl"
            multiple
        :headers="upheaders"
        :on-change="handleChange"
        :on-success="handleSuccess"
        :file-list="fileList"
        ref="upload"
          >
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">
              将文件拖到此处，或<em>点击上传</em>
            </div>
          </el-upload>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeCombination">取 消</el-button>
        <el-button type="success" @click="handleApplyMulti">申请</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  toAuthorizationUser,
  selectFinaceUser,
  addFinance,
  addFinanceMulti,
} from "../../api/finance";
export default {
  data() {
    return {
      options: [
        {
          value: 6,
          label: "六个月",
        },
        {
          value: 12,
          label: "一年",
        },
        {
          value: 24,
          label: "两年",
        },
        {
          value: 36,
          label: "三年",
        },
      ],
      value: "",
      dialogImageUrl: "",
      dialogVisible: false,
      showBtnImg: true,
      noneBtnImg: false,
      limitCountImg: 1,
      fileInfo:"",
      upheaders: {
        Authorization: window.localStorage.token,
      },
      fileList: [],
      imgurl: "",
      upurl: this.$store.state.fileUploadRoad + "/file/uploadInfo/info",
      data: [],
      Already: false,
      AuthorizationUser: {
        userName: "",
      },
      AlreadyApplied: {
        applied: "",
      },
      title: "个人贷款信息",
      isAuthorization: true,
      showIndividual: false,
      showCombination: false,
      showAdd: false,
      FinaceUserDetails: {
        bankName: "",
        name: "",
        money: "",
        rate: "",
        repayment: "",
        phone: "",
        idNum: "",
        address: "",
        introduce: "",
      },
      UserDetailsMulti: {
        money: "",
        rate: "",
        repayment: "",

        realName: "",
        phone: "",
        idNum: "",

        combinationName1: "",
        combinationPhone1: "",
        combinationIdnum1: "",

        combinationName2: "",
        combinationPhone2: "",
        combinationIdnum2: "",
      },
    };
  },
  filters: {
    changeTime(time) {
      return time.slice(0, 10);
    },
  },
  props: {
    ctype: {
      type: String,
    },
    cdesciibe: {
      type: String,
    },
  },
  methods: {
    handleApplyOne() {
      if (localStorage.getItem("token")) {
        console.log("信息");
        console.log(this.FinaceUserDetails);

        if (
          this.FinaceUserDetails.name == "" ||
          this.FinaceUserDetails.name == null
        ) {
          alert("姓名不能为空");
          return;
        }
        if (
          this.FinaceUserDetails.money == "" ||
          this.FinaceUserDetails.money == null
        ) {
          alert("融资额度不能为空");
          return;
        }
        if (this.value == "" || this.value == null) {
          alert("意向借款期不能为空");
          return;
        }
        if (
          this.FinaceUserDetails.phone == "" ||
          this.FinaceUserDetails.phone == null
        ) {
          alert("联系方式不能为空");
          return;
        }
        if (
          this.FinaceUserDetails.idNum == "" ||
          this.FinaceUserDetails.idNum == null
        ) {
          alert("身份证号不能为空");
          return;
        }
        if (
          this.$store.state.mutiFile == "" ||
          this.$store.state.mutiFile == null
        ) {
          alert("资料不能为空");
          return;
        }

        addFinance({
          bankId: window.localStorage.financeObj.substring(10, 14),
          realName: this.FinaceUserDetails.name,
          money: this.FinaceUserDetails.money,
          rate: this.FinaceUserDetails.rate,
          repayment: this.value,
          phone: this.FinaceUserDetails.phone,
          idNum: this.FinaceUserDetails.idNum,
          fileInfo:this.$store.state.mutiFile
        })
          .then((res) => {
            if (res.flag == true) {
              this.$message.success(res.message);
              // this.$router.push("/home/financing").catch((err) => err);
              localStorage.removeItem("financeObj");
              this.Already = true;
              this.showIndividual = false;
              this.$store.state.mutiFile="";
            } else {
              this.$message.error(res.message);
              this.$store.state.mutiFile="";
            }
          })
          .catch((err) => {
            console.log(err);
            this.$message.error(err.message);
            this.$store.state.mutiFile="";
          });
      } else {
        this.$message.error("请先登录");
        this.$router.push(`/login`).catch((err) => err);
      }
    },
    handleApplyMulti() {
      if (localStorage.getItem("token")) {
        if (
          this.UserDetailsMulti.money == "" ||
          this.UserDetailsMulti.money == null
        ) {
          alert("融资额度不能为空");
          return;
        }
        if (this.value == "" || this.value == null) {
          alert("意向借款期不能为空");
          return;
        }
        if (
          this.UserDetailsMulti.realName == "" ||
          this.UserDetailsMulti.realName == null
        ) {
          alert("姓名不能为空");
          return;
        }
        if (
          this.UserDetailsMulti.phone == "" ||
          this.UserDetailsMulti.phone == null
        ) {
          alert("联系方式不能为空");
          return;
        }
        if (
          this.UserDetailsMulti.idNum == "" ||
          this.UserDetailsMulti.idNum == null
        ) {
          alert("身份证号不能为空");
          return;
        }
        if (
          this.UserDetailsMulti.combinationName1 == "" ||
          this.UserDetailsMulti.combinationName1 == null
        ) {
          alert("用户2姓名不能为空");
          return;
        }
        if (
          this.UserDetailsMulti.combinationPhone1 == "" ||
          this.UserDetailsMulti.combinationPhone1 == null
        ) {
          alert("用户2联系方式不能为空");
          return;
        }
        if (
          this.UserDetailsMulti.combinationIdnum1 == "" ||
          this.UserDetailsMulti.combinationIdnum1 == null
        ) {
          alert("用户2身份证号不能为空");
          return;
        }
        if (
          this.$store.state.mutiFile == "" ||
          this.$store.state.mutiFile == null
        ) {
          alert("资料不能为空");
          return;
        }

        addFinanceMulti({
          bankId: window.localStorage.financeObj.substring(10, 14),
          money: this.UserDetailsMulti.money,
          rate: this.UserDetailsMulti.rate,
          repayment: this.value,

          realName: this.UserDetailsMulti.realName,
          phone: this.UserDetailsMulti.phone,
          idNum: this.UserDetailsMulti.idNum,

          combinationName1: this.UserDetailsMulti.combinationName1,
          combinationPhone1: this.UserDetailsMulti.combinationPhone1,
          combinationIdnum1: this.UserDetailsMulti.combinationIdnum1,

          combinationName2: this.UserDetailsMulti.combinationName2,
          combinationPhone2: this.UserDetailsMulti.combinationPhone2,
          combinationIdnum2: this.UserDetailsMulti.combinationIdnum2,

          fileInfo:this.$store.state.mutiFile
        })
          .then((res) => {
            if (res.flag == true) {
              this.$message.success(res.message);
              // this.$router.push("/home/financing").catch((err) => err);
              localStorage.removeItem("financeObj");
              this.Already = true;
              this.showCombination = false;
              this.$store.state.mutiFile="";
            } else {
              this.$message.error(res.message);
              this.$store.state.mutiFile="";
            }
          })
          .catch((err) => {
            console.log(err);
            this.$message.error(err.message);
            this.$store.state.mutiFile="";
          });
      } else {
        this.$message.error("请先登录");
        this.$router.push(`/login`).catch((err) => err);
      }
    },
    individual() {
      this.title = "个人贷款信息";
      this.$store.state.mutiFile="";
      selectFinaceUser({
        bank_id: window.localStorage.financeObj.substring(10, 14),
      }).then((res) => {
        this.showIndividual = true;
        this.showCombination = false;
        if (res.flag == true) {
          this.FinaceUserDetails = res.data;

          console.log(this.$route.query.bankId);
        } else {
          console.log(this.$route.query.bankId);
          this.$message.error(res.data);
        }
      });
    },
    select() {
      selectFinaceUser({
        bank_id: window.localStorage.financeObj.substring(10, 14),
      }).then((res) => {
        if (res.flag == true) {
          this.FinaceUserDetails = res.data;
          console.log(this.FinaceUserDetails);
        } else {
          console.log(window.localStorage.financeObj.substring(10, 14));
          this.$message.error(res.data);
        }
      });
    },
    combination() {
      this.title = "组合贷款信息";
      this.$store.state.mutiFile="";
      selectFinaceUser({
        bank_id: window.localStorage.financeObj.substring(10, 14),
      }).then((res) => {
        this.showCombination = true;
        this.showIndividual = false;
        if (res.flag == true) {
          this.UserDetailsMulti = res.data;

          console.log(this.$route.query.bankId);
        } else {
          console.log(this.$route.query.bankId);
          this.$message.error(res.data);
        }
      });
    },
    Authorization() {
      this.showAdd = true;
    },
    closeAdd() {
      this.showAdd = false;
    },
    closeIndividual() {
      this.showIndividual = false;
      this.$store.state.mutiFile="";
    },
    closeCombination() {
      this.showCombination = false;
      this.$store.state.mutiFile="";
    },
    toAuthorization() {
      if (this.AuthorizationUser.userName == "") {
        alert("用户名不能为空");
        return;
      }
      toAuthorizationUser({
        userName: this.AuthorizationUser.userName,
      }).then((res) => {
        if (res.flag == true) {
          this.$message.success(res.message);
          this.showAdd = false;
          this.isAuthorization = false;
        } else {
          this.showAdd = false;
          this.$message.error(res.data);
        }
      });
    },
        handleError(err, file, fileList) {
      this.$message({
        message: "上传失败！",
        type: "success",
      });
      console.log(err);
    },
    handleSuccess(response, file, fileList) {
      if (file.response.flag == true) {
        this.fileList = fileList;
        this.$store.state.mutiFile += file.response.data + " ";
        console.log("上传文件=====")
        console.log(this.$store.state.mutiFile)
        console.log("=============")
        if (fileList.length >= 1) {
          this.uploadDisabled = true;
        }
        alert(file.response.message);
      } else {
        alert(file.response.data);
      }
    },
    handleChange(file, fileList) {
      this.noneBtnImg = fileList.length >= this.limitCountImg;
    },
    handleRemove(file, fileList) {
      this.noneBtnImg = fileList.length >= this.limitCountImg;
      this.fileList = [];
      // this.form.photo = "";
      this.uploadDisabled = false;
    },
    handlePreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
  },
  created() {
    // this.individual()
    this.select();
    this.form = Object.assign(
      {},
      { ...JSON.parse(localStorage.getItem("financeObj")) }
    );
  },
};
</script>

<style lang="less" scoped>
.details-box2 {
  width: 1100px;
  margin: 10px auto;
  background: #fff;
  min-height: 100%;
  height: auto;
  padding: 10px 20px;
  img {
    width: 300px;
    height: 300px;
    float: left;
    margin-right: 20px;
  }
  .title {
    font-size: 18px;
    line-height: 40px;
  }
  .introduce {
    line-height: 25px;
    max-height: 100px;
  }
  .item-content {
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    height: 30px;
    line-height: 30px;
    .item-title {
      font-weight: bold;
    }
    .item-text {
    }
  }
  .info {
    position: relative;
    width: 340px;
    height: 300px;
    float: left;
    .title {
      font-size: 22px;
      font-weight: bold;
    }
    .content {
      height: 100px;
    }
    .price {
      color: red;
      font-size: 25px;
      font-weight: bold;
    }
    .time {
      margin-top: 10px;
      color: #999;
      .createtime {
        float: left;
      }
      .updatetime {
        float: right;
      }
    }
  }
  .operation {
    position: absolute;
    bottom: 0;
    margin-top: 20px;
    .like,
    .collection,
    .comment {
      display: inline-block;
      width: 30px;
      margin-right: 30px;
      img {
        margin: 0;
        width: 20px;
        height: 20px;
        border-radius: 6px;
      }
    }
  }
  .add-shopcart {
    position: absolute;
    right: 20px;
    bottom: 5px;
  }
}
.btn-style {
  display: flex;
  justify-content: center;
}
</style>
