<template>
  <div>
    <div v-for="(item, index) in FinanceAllData" :key="index">
      <el-descriptions
        class="margin-top"
        :column="2"
        :size="size"
        title="我的融资信息"
        border
        style="width: 100%"
      >
        <template slot="extra">
          <!-- <span style="left"> 我的融资信息 {{index+1}}</span> -->
          <el-button
            type="warning"
            size="small"
            @click="updateFinaceShow(item.financeId)"
            >修改</el-button
          >
          <el-button
            type="danger"
            size="small"
            @click="deleteFinace(item.financeId)"
            >删除</el-button
          >
        </template>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            姓名
          </template>
          {{ item.realName }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机号
          </template>
          {{ item.phone }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            身份证号
          </template>
          {{ item.idNum }}
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-money"></i>
            融资金额
          </template>
          {{ item.money }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            银行
          </template>
          {{ getBankName(item.bankId) }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-s-release"></i>
            利率
          </template>
          {{ item.rate }}
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-warning-outline"></i>
            申请状态
          </template>
          <template >
          <el-tag type="danger" v-show="item.status === 0">申请中</el-tag>
          <el-tag type="danger" v-show="item.status === 1">驳回</el-tag>
          <el-tag type="danger" v-show="item.status === 2">通过</el-tag>
        </template>
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            联合融资人1姓名
          </template>
          {{ item.combinationName1 }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            联合融资人1手机号
          </template>
          {{ item.combinationPhone1 }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            联合融资人1身份证
          </template>
          {{ item.combinationIdnum1 }}
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            联合融资人2姓名
          </template>
          {{ item.combinationName2 }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            联合融资人2手机号
          </template>
          {{ item.combinationPhone2 }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            联合融资人2身份证
          </template>
          {{ item.combinationIdnum2 }}
        </el-descriptions-item>
      </el-descriptions>
    </div>

    <el-dialog
      :title="title"
      :visible.sync="showUpdate"
      width="580px"
      :before-close="closeUpdate"
    >
      <el-form
        v-model="FinanceData"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <strong style="color: green">修改融资信息：</strong>
        <el-form-item label="融资额度：" prop="money">
          <el-input v-model="FinanceData.money"></el-input>
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

        <strong style="color: green">用户1：</strong>
        <el-form-item label="姓名：" prop="realName">
          <el-input v-model="FinanceData.realName"></el-input>
        </el-form-item>
        <el-form-item label="联系方式：" prop="phone">
          <el-input v-model="FinanceData.phone"></el-input>
        </el-form-item>
        <el-form-item label="身份证号：" prop="idNum">
          <el-input v-model="FinanceData.idNum"></el-input>
        </el-form-item>

        <strong style="color: green">用户2：</strong>
        <el-form-item label="姓名：" prop="combinationName1">
          <el-input v-model="FinanceData.combinationName1"></el-input>
        </el-form-item>
        <el-form-item label="联系方式：" prop="combinationPhone1">
          <el-input v-model="FinanceData.combinationPhone1"></el-input>
        </el-form-item>
        <el-form-item label="身份证号：" prop="combinationIdnum1">
          <el-input v-model="FinanceData.combinationIdnum1"></el-input>
        </el-form-item>

        <strong style="color: green">用户3：</strong>
        <el-form-item label="姓名：" prop="combinationName2">
          <el-input v-model="FinanceData.combinationName2"></el-input>
        </el-form-item>
        <el-form-item label="联系方式：" prop="combinationPhone2">
          <el-input v-model="FinanceData.combinationPhone2"></el-input>
        </el-form-item>
        <el-form-item label="身份证号：" prop="combinationIdnum2">
          <el-input v-model="FinanceData.combinationIdnum2"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeUpdate">取 消</el-button>
        <el-button type="success" @click="updateFinace">确定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import { selectByName, updateById, deleteById,selectFinaceById } from "../api/finance.js";
export default {
  data() {
    return {
      size: "",
      FinanceAllData: [],
      FinanceData: {
        financeId: "",
        bankName: "",
        bankId: "",
        realName: "",

        phone: "",
        idNum: "",
        money: "",
        repayment: "",
        combinationName1: null,
        combinationPhone1: null,
        combinationIdnum1: null,
        combinationName2: null,
        combinationPhone2: null,
        combinationIdnum2: null,
      },
      showUpdate: false,
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
    };
  },
  methods: {
    getBankName(bankId) {
      if (bankId == "1005") {
        return "日照银行";
      }
      if (bankId == "1001") {
        return "青岛银行";
      }
      if (bankId == "1002") {
        return "中国银行";
      }
      if (bankId == "1004") {
        return "中国工商银行";
      }
      if (bankId == "1006") {
        return "华夏银行";
      }
      if (bankId == "1007") {
        return "中国建设银行";
      }
      if (bankId == "1008") {
        return "浦发银行";
      }
      if (bankId == "1009") {
        return "中国平安银行";
      }
      if (bankId == "1010") {
        return "中国民生银行";
      }

    },
    getData() {
      selectByName({}).then((res) => {
        if (res.flag == true) {
          this.FinanceAllData = res.data;
          console.log("bankId");
          console.log(res.data.bankId);
          if (res.data.bankId === "1005") {
            this.FinanceAllData.bankName = "日照银行";
          }
        } else {
          this.$message.error(res.data);
        }
      });
    },
    updateFinaceShow(item) {
      this.showUpdate = true;
      this.FinanceData.financeId = item;
      selectFinaceById({id:this.FinanceData.financeId}).then((res) => {
        if (res.flag == true) {
          this.FinanceData = res.data;
          console.log("bankId");
          console.log(res.data.bankId);

        } else {
          this.$message.error(res.data);
        }
      });

    },
    updateFinace() {
      if (
          this.FinanceData.money == "" ||
          this.FinanceData.money == null
        ) {
          alert("融资额度不能为空");
          return;
        }
        if (this.value == "" || this.value == null) {
          alert("意向借款期不能为空");
          return;
        }
        if (
          this.FinanceData.realName == "" ||
          this.FinanceData.realName == null
        ) {
          alert("姓名不能为空");
          return;
        }
        if (
          this.FinanceData.phone == "" ||
          this.FinanceData.phone == null
        ) {
          alert("联系方式不能为空");
          return;
        }
        if (
          this.FinanceData.idNum == "" ||
          this.FinanceData.idNum == null
        ) {
          alert("身份证号不能为空");
          return;
        }

      updateById({
        rate: 1.2,
        financeId: this.FinanceData.financeId,
        realName: this.FinanceData.realName,
        phone: this.FinanceData.phone,
        idNum: this.FinanceData.idNum,
        money: this.FinanceData.money,
        repayment: this.value,
        combinationName1: this.FinanceData.combinationName1,
        combinationPhone1: this.FinanceData.combinationPhone1,
        combinationIdnum1: this.FinanceData.combinationIdnum1,
        combinationName2: this.FinanceData.combinationName2,
        combinationPhone2: this.FinanceData.combinationPhone2,
        combinationIdnum2: this.FinanceData.combinationIdnum2,
      })
        .then((res) => {
          if (res.flag == true) {
            this.$message.success(res.message);
            this.getData();
            this.showUpdate = false;
          } else {
            this.$message.error(res.data);
          }
        })
        .catch((err) => {
          console.log("修改失败");
        });
    },
    deleteFinace(item) {
        this.$confirm("确认删除该信息?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        // type: 'warning'
      }).then(() => {
      deleteById({
        financeId: item,
      })
        .then((res) => {
          if (res.flag == true) {
            this.$message.success(res.message);
            this.getData();
          } else {
            this.$message.error(res.data);
          }
        })
        .catch((err) => {
          console.log("删除失败");
        });
    }).catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    closeUpdate() {
      this.showUpdate = false;
    },
  },
  created() {
    this.getData();
  },
};
</script>
<style>
.el-descriptions {
  padding-left: 20px;
  padding-right: 20px;
  padding-bottom: 20px;
}
</style>
