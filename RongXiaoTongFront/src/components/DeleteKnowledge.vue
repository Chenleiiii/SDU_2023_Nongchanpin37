<template>
  <div class="delete-message">
    <div @click="dialogVisible = true" class="delete">删除</div>
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
import { deleteKnowledgeById } from "../api/knowledge";
export default {
  inject: ["reload"],
  data() {
    return {
      dialogVisible: false,
    };
  },
  methods: {
    deleteMessageClick() {
      this.dialogFormVisible = false;
      deleteKnowledgeById({
        knowledgeId: this.$store.state.changedKnowledgeId,
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
  .delete {
    height: 25px;
    cursor: pointer;
    margin-right: 10px;
    color: #67C23A;
    &:hover{
      color: #035D1C;
    }
  }
}
</style>