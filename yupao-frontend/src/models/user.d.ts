/**
 * 用户类别
 */
export type UserType = {
    id: number;
    username: string;
    userAccount: string;
    avatarUrl?: string;
    phone: string;
    gender: number;
    email: string;
    userStatus: number;
    userRole: number;
    tags: string[];
    planetCode: string;
    createTime: Date;
}
