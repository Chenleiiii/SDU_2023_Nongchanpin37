<template>
  <div class="delete-message">
    <div class="delete-text" @click="dialogVisible = true">删除</div>

    <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
      <span>确认删除该商品？</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="success" @click="deleteMessageClick">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { deleteOrderById } from "../api/order";
export default {
  inject: ["reload"],
  data() {
    return {
      dialogVisible: false,
    };
    this.dialogFormVisible = false;
  },
  methods: {
    deleteMessageClick() {
      deleteOrderById({
        order_id: this.$store.state.changedOrderId,
      })
        .then((res) => {
          this.reload();
          alert("删除成功");
        })
        .catch((err) => {
          alert("删除失败");
        });
    },
  },
};
</script>

<style lang="less" scoped>
.delete-message {
  .delete-text {
    height: 25px;
    cursor: pointer;
    color: #67C23A;
    &:hover{
      color: #035D1C;
    }
  }
}
</style>