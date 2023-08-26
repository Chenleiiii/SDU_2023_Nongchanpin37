<template>
  <div class="user-manage">
    <el-table
      ref="multipleTable"
      tooltip-effect="dark"
      style="width: 100%"
      :data="userData">
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="userName" label="用户名">
      </el-table-column>
      <el-table-column prop="nickName" label="昵称">
      </el-table-column>
      <el-table-column
        prop="identityNum"
        label="身份证"
        width="120"
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column prop="role" label="角色" width="140"> </el-table-column>
      <el-table-column prop="phone" label="电话" width="120"> </el-table-column>
      <el-table-column prop="address" label="地址" show-overflow-tooltip>
      </el-table-column>
      <el-table-column label="创建日期" width="100">
        <template slot-scope="scope">{{
          scope.row.createTime.slice(0, 10)
        }}</template>
      </el-table-column>
      <el-table-column label="修改日期" width="100">
        <template slot-scope="scope">{{ scope.row.updateTime.slice(0, 10)}}</template>
      </el-table-column>
      <el-table-column label="操作" width="110">
        <template slot-scope="scope">
          <div>
            <el-button type="success" icon="el-icon-edit" circle
              @click="managerChangeInfo(scope.row.userName)"></el-button>
            <el-button type="danger" icon="el-icon-delete" circle
              @click="deleteUserNameClick(scope.row.userName)"></el-button>
            <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
              <span>确认删除该用户</span>
              <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="success" @click="managerDeleteUser(deleteUserName)">确 定</el-button>
              </span>
            </el-dialog>
          </div>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      title="用户信息"
      :visible.sync="dialogFormVisible"
      class="manager-change-user-info"
    >
      <el-form class="user-info">
        <el-form-item
          label="用户名"
          :label-width="formLabelWidth"
          class="manager-change-name"
        >
          <el-input
            autocomplete="off"
            v-model="updateUserData.userName"
            :disabled="true"
          ></el-input>
        </el-form-item>
        <el-form-item
          label="昵称"
          :label-width="formLabelWidth"
          class="manager-change-phone"
        >
          <el-input
            autocomplete="off"
            v-model="updateUserData.nickName"
          ></el-input>
        </el-form-item>
        <el-form-item
          label="身份证号"
          :label-width="formLabelWidth"
          class="manager-change-phone"
        >
          <el-input
            autocomplete="off"
            v-model="updateUserData.identityNum"
          ></el-input>
        </el-form-item>
        <el-form-item
          label="角色"
          :label-width="formLabelWidth"
          class="manager-change-role"
        >
          <el-input autocomplete="off" v-model="updateUserData.role"></el-input>
        </el-form-item>
        <el-form-item
          label="电话"
          :label-width="formLabelWidth"
          class="manager-change-phone"
        >
          <el-input
            autocomplete="off"
            v-model="updateUserData.phone"
          ></el-input>
        </el-form-item>
        <el-form-item
          label="地址"
          :label-width="formLabelWidth"
          class="manager-change-address"
        >
          <el-input
            autocomplete="off"
            v-model="updateUserData.address"
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="success" @click="submitCHangeInfo">确 定</el-button>
      </div>
    </el-dialog>
    <pagination
      :cUrl="url"
      :cTotal="total"
      :cPageSize="pageSize"
      @item-click="pageClick"
    ></pagination>
  </div>
</template>

<script>
import {
  selectUserByUsername,
  deleteUserByUsername,
  updateUserByUsername,
  selectAllUserPage,
} from "../api/user";
import Pagination from "../components/Pagination.vue";
export default {
  inject: ["reload"],
  components: { Pagination },
  data() {
    return {
      userData: [],
      dialogVisible: false,
      dialogTableVisible: false,
      dialogFormVisible: false,
      formLabelWidth: "120px",
      deleteUserName: "",
      total: 0,
      pageSize: 9,
      url: "/user/search/",
      usersCount: sessionStorage.getItem("/user/search/pageCode")
        ? sessionStorage.getItem("/user/search/pageCode")
        : 1,
      updateUserData: {},
    };
  },
  methods: {
    pageClick(item) {
      this.userData = item;
    },
    managerChangeInfo(userName) {
      this.dialogFormVisible = true;
      selectUserByUsername({
        user_name: userName,
      }).then((res) => {
        this.updateUserData = res.data;
      });
    },
    deleteUserNameClick(deleteUserName) {
      this.deleteUserName = deleteUserName;
      this.dialogVisible = true;
    },
    managerDeleteUser(userName) {
      this.dialogVisible = false;
      deleteUserByUsername({
        user_name: userName,
      }).then((res) => {
        if (res.flag == true) {
          alert(res.message);
          this.reload();
        } else {
          alert(res.data);
        }
      });
    },
    submitCHangeInfo() {
      this.dialogFormVisible = false;
      updateUserByUsername({
        user_name: this.updateUserData.userName,
        nickName: this.updateUserData.nickName,
        identityNum: this.updateUserData.identityNum,
        phone: this.updateUserData.phone,
        address: this.updateUserData.address,
        role: this.updateUserData.role,
      }).then((res) => {
          if (res.flag == true) {
            alert(res.message);
            this.reload();
          } else {
            alert(res.data);
          }
        })
        .catch((err) => {
          alert("修改失败");
        });
    },
  },
  created() {
    this.$store.commit("updateUserActiveIndex", "5");
      selectAllUserPage({
        pageNum:this.usersCount,
      }).then((res) => {
        this.userData = res.data.list;
        this.total = res.data.total;
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>

<style lang="less" scoped>
.user-manage {
  width: 1100px;
  background: #fff;
  margin: 10px auto;
  padding: 10px 20px;
  .manager-change-user-info {
    .el-dialog {
      width: 500px;
      .el-dialog__body {
        height: 400px;
        .user-info {
          width: 400px;
          padding: 0;
          .manager-change-name,
          .manager-change-password,
          .manager-change-phone,
          .manager-change-address {
            .el-form-item__label {
              width: 100px !important;
            }
            width: 400px;
            margin-right: 200px;
          }
        }
      }
    }
  }
}
</style>