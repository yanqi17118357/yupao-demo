<template>
    <van-form @submit="onSubmit">
            <van-field autocomplete="off"
                    v-model="editUser.currentValue"
                    :name="editUser.editKey as String"
                    :label="editUser.editName as String"
                    :placeholder="`请输入${editUser.editName}`"
            />
        <div style="margin: 16px;">
            <van-button round block type="primary" native-type="submit">
                提交
            </van-button>
        </div>
    </van-form>
</template>

<script setup lang="ts">
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";
import myAxios from "../plugins/myAxios.ts";
import {showFailToast, showSuccessToast} from "vant";

const route = useRoute();
const router = useRouter();
const editUser = ref({
    editKey: route.query.editKey,
    editName: route.query.editName,
    currentValue: route.query.currentValue,
})
const onSubmit = async () => {
    const res = await myAxios.post('/user/update',{
        id: 12,
        // 动态语法
        [editUser.value.editKey]: editUser.value.currentValue,
    });
    console.log(res);
    if (res.code === 0 && res.data > 0) {
        showSuccessToast('修改成功');
        router.back();
    } else {
        showFailToast('更新失败');
    }
}
</script>

<style scoped>

</style>
