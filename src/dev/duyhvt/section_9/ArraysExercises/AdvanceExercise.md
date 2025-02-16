Tuyệt! Dưới đây là một số bài tập nâng cao hơn một chút dựa trên **Arrays** và **Sorting**, nhưng vẫn phù hợp với level của bạn:

---

### **Bài 1: Sắp xếp mảng chẵn lẻ riêng biệt**
Viết một chương trình nhận vào một mảng số nguyên, sau đó:
- Tách số **chẵn** và **lẻ** ra hai nhóm riêng biệt.
- Sắp xếp nhóm số **chẵn** theo thứ tự **giảm dần**.
- Sắp xếp nhóm số **lẻ** theo thứ tự **tăng dần**.
- Gộp hai nhóm lại thành một mảng mới và in kết quả.

**Ví dụ:**  
Input: `[4, 1, 3, 8, 6, 9, 2, 5]`  
Output: `[8, 6, 4, 2, 1, 3, 5, 9]`

---

### **Bài 2: Tìm phần tử lớn thứ hai trong mảng**
Viết một phương thức **findSecondLargest(int[] array)** để tìm **số lớn thứ hai** trong một mảng số nguyên.
- Bạn **không** được sử dụng `Arrays.sort()`.
- Nếu tất cả các phần tử đều giống nhau, trả về giá trị đó.
- Nếu mảng có ít hơn **hai phần tử**, in ra `"Không đủ phần tử"`.

**Ví dụ:**  
Input: `[10, 5, 8, 20, 15]` → Output: `15`  
Input: `[7, 7, 7, 7]` → Output: `7`  
Input: `[5]` → Output: `"Không đủ phần tử"`

---

### **Bài 3: Xoay mảng (Array Rotation)**
Viết một phương thức **rotateArray(int[] array, int k)** để **xoay mảng sang phải** `k` lần.
- Ví dụ, nếu `k = 2`, thì phần tử cuối cùng sẽ được đẩy lên **đầu mảng** 2 lần.
- Bạn **không** được sử dụng thư viện có sẵn như `Collections.rotate()`.

**Ví dụ:**  
Input: `array = [1, 2, 3, 4, 5], k = 2`  
Output: `[4, 5, 1, 2, 3]`

---

### **Bài 4: Loại bỏ phần tử trùng lặp khỏi mảng**
Viết một phương thức nhận vào một mảng số nguyên và trả về **một mảng mới** không chứa phần tử trùng lặp.
- Không được dùng `Set` hoặc `HashMap`.
- Kết quả giữ nguyên thứ tự xuất hiện của các phần tử đầu tiên.

**Ví dụ:**  
Input: `[1, 2, 2, 3, 4, 4, 5, 6, 6]`  
Output: `[1, 2, 3, 4, 5, 6]`

---

### **Bài 5: Đảo ngược số nguyên (Reverse Digits)**
Viết một phương thức **reverseDigits(int n)** để đảo ngược chữ số của một số nguyên **không dùng String**.

**Ví dụ:**  
Input: `12345` → Output: `54321`  
Input: `-987` → Output: `-789`

---

🔥 Mấy bài này giúp bạn **hiểu sâu hơn về Arrays** và tư duy **xử lý dữ liệu** trong Java. 