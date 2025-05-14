#include <stdio.h>
#include <stdlib.h> // 用于malloc和exit函数

#define MAXSIZE 100  // 最大容量
#define Status int
#define OK 1
#define ERROR 0
#define OVERFLOW -1

typedef int ElemType; // 假设元素类型为int

typedef struct {
    ElemType *elem;  // 存储空间的基地址
    int length;      // 当前长度
} SqList;

// 1.初始化
Status InitList(SqList *L) {

    /* 构造一个空的顺序表L，为L的指针分配内存空间 */
    L->elem = (ElemType*)malloc(MAXSIZE * sizeof(ElemType)); // 分配数组空间
    
    if (!L->elem) {
        exit(OVERFLOW); // 存储分配失败退出
    }
    
    L->length = 0; // 空表长度为0
    return OK;
}

// 2.随机访问
Status GetElem(SqList L, int i, ElemType *e)
{
    if (i < 1 || i > L.length)
        return ERROR;

    *e = L.elem[i-1];
    return OK;
}

// 3.查找
int LocateElem(SqList L, ElemType e)
{
    for(int i = 0; i < L.length; i++)
    {
        if (L.elem[i] == e) 
            return i+1;
    }
}

// 4.插入元素
Status ListInsert(SqList *L, int i, ElemType e)
{
    // 检查插入位置是否合法
    if (i < 1 || i > L->length + 1)
        return ERROR;
    if (L->length >= MAXSIZE)
        return ERROR;
    if (L->length > 0) {
        for(int j = L->length - 1; j >= i - 1; j--)
            L->elem[j+1] = L->elem[j];
    }

    L->elem[i-1] = e;
    ++L->length;
    return OK;
}

// 5.删除元素
Status ListDelete(SqList *L, int i, ElemType *e)
{
    if (L->length == 0)
        return ERROR;
    // 检查删除位置
    if (i < 1 || i > L->length)
        return ERROR;
    // 存储删除的值
    *e = L->elem[i-1];
    // 移动元素
    // 遍历到倒数第二个元素
    for (int j = i - 1; j < L->length - 1;j++)
        L->elem[j] = L->elem[j+1];
    // 长度-1
    L->length--;
    return OK;
}