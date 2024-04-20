package unionfindsets;

import org.junit.Test;

import java.util.*;

/**
 * @Author:zxp
 * @Description:给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * 示例 2：
 *
 * 输入：accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * 输出：[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 *
 *
 * 提示：
 *
 * 1 <= accounts.length <= 1000
 * 2 <= accounts[i].length <= 10
 * 1 <= accounts[i][j].length <= 30
 * accounts[i][0] 由英文字母组成
 * accounts[i][j] (for j > 0) 是有效的邮箱地址
 * @Date:10:43 2024/2/17
 */
public class AccountsMerge {
    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> accounts=new ArrayList<>();
        List<String> strings=new ArrayList<>();
        List<String> strings1=new ArrayList<>();
        List<String> strings2=new ArrayList<>();
        List<String> strings3=new ArrayList<>();
        List<String> strings4=new ArrayList<>();
        strings.add("David");
        strings.add("David0@m.co");
        strings.add("David4@m.co");
        strings.add("David3@m.co");
        accounts.add(strings);
        strings1.add("David");
        strings1.add("David5@m.co");
        strings1.add("David5@m.co");
        strings1.add("David0@m.co");
        accounts.add(strings1);
        strings2.add("David");
        strings2.add("David1@m.co");
        strings2.add("David4@m.co");
        strings2.add("David0@m.co");
        accounts.add(strings2);
        strings3.add("David");
        strings3.add("David0@m.co");
        strings3.add("David1@m.co");
        strings3.add("David3@m.co");
        accounts.add(strings3);
        strings4.add("David");
        strings4.add("David4@m.co");
        strings4.add("David1@m.co");
        strings4.add("David3@m.co");
        accounts.add(strings4);
        System.out.println(accountsMerge.accountsMerge(accounts));
    }
    int[] fa;
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        List<List<String>> result=new ArrayList<>();
        int n=accounts.size();
        fa=new int[n];
        init();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSameAccount(accounts.get(i),accounts.get(j))){
                    union(i,j);
                }
            }
        }
        List<List<Integer>> record=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<>();
            list.add(i);
            record.add(list);
        }
        for(int i=0;i<record.size();i++){
            for(int j=i+1;j<record.size();j++){
                List<Integer> front = record.get(i);
                List<Integer> back = record.get(j);
                if(find(front.get(0))==find(back.get(0))){
                    record.get(i).add(record.get(j).get(0));
                    record.remove(j);
                    j--;
                }
            }
        }
        for(int i=0;i<record.size();i++){
            List<Integer> set = record.get(i);
            List<String> union=new ArrayList<>();
            String s = accounts.get(set.get(0)).get(0);
            for(int j=0;j<set.size();j++){
                Integer integer = set.get(j);
                List<String> strings = accounts.get(integer);
                union=getUnion(union,strings);
            }
            List<String> subResult=new ArrayList<>();
            subResult.add(union.get(0));
            union.remove(0);
            Collections.sort(union, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareToIgnoreCase(o2);
                }
            });
            for(int k=0;k<union.size();k++){
                subResult.add(union.get(k));
            }
            result.add(subResult);
        }
        return result;
    }
    public void init(){
        for(int i=0;i< fa.length;i++)
            fa[i]=i;
    }
    public int find(int i){
        if(fa[i]==i)
            return i;
        else {
            fa[i]=find(fa[i]);
            return fa[i];
        }
    }
    public void union(int u,int v){
        u=find(u);
        v=find(v);
        if(u==v)
            return;
        fa[u]=v;
    }
    public List<String> getUnion(List<String> union,List<String> string){
        for(int i=0;i<string.size();i++){
            if(!union.contains(string.get(i)))
                union.add(string.get(i));
        }
        return union;
    }
    public boolean isSameAccount(List<String> string1,List<String> string2){
        if(!string1.get(0).equals(string2.get(0)))
            return false;
        else {
            for(int i=0;i<string1.size();i++){
                if(string2.contains(string1.get(i))&&i!=0)
                    return true;
            }
        }
        return false;
    }
}