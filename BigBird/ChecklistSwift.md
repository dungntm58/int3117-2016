# Raywenderlich.com Official Swift Style Guide.

Style guide này rất khác so với nhiều style guide khác, bởi vì trọng tâm là tập trung vào khả năng hiển thị cho in ấn và web. Chúng tôi tạo ra Style guide này để giữ cho mã nguồn trong các cuốn sách, các tài liệu hướng dẫn,... của chúng tôi trông đẹp rõ ràng và nhất quán - mặc dù chúng tôi có nhiều tác giả khác nhau viết bài.

Mục tiêu tổng quát của chúng tôi là súc tích, dễ đọc, và đơn giản.

Sử dụng Objective-C? Xem [Objective-C Style Guide] (https://github.com/raywenderlich/objective-c-style-guide) .

## Mục lục

Comming soon


## Tính đúng đắn

Hãy xem xét các cảnh báo là lỗi. Quy tắc này quyết định rằng bạn sẽ không sử dụng những thành phần đã bị hạn chế và lỗi thời như toán tử `++` or `--`, vòng lặp kiểu C, hoặc sử dụng các chuỗi như selectors.

## Đặt tên

Sử dụng tên có tính mô tả với phong cách lạc đà cho các lớp, phương thức, các biến, vv. Loại tên (các lớp, cấu trúc, kiểu liệt kê và các giao thức) nên được viết in hoa, trong khi tên phương thức và các biến nên bắt đầu với một chữ thường.

**Nên:**

```swift
private let maximumWidgetCount = 100

class WidgetContainer {
  var widgetButton: UIButton
  let widgetHeightPercentage = 0.85
}
```

**Không nên:**

```swift
let MAX_WIDGET_COUNT = 100

class app_widgetContainer {
  var wBut: UIButton
  let wHeightPct = 0.85
}
```

Chữ viết tắt và từ viết tắt thường nên tránh. Theo như [Hướng dẫn thiết kế API] (https://swift.org/documentation/api-design-guidelines/#follow-case-conventions), chữ viết tắt và từ viết tắt xuất hiện trong tất cả các chữ hoa nên được thống nhất chữ hoa hay chữ thường. Ví dụ:

**Preferred**
```swift
let urlString: URLString
let userID: UserID
```

**Not Preferred**
```swift
let uRLString: UrlString
let userId: UserId
```

Đối với hàm và phương thức init, nên đặt tên các tham số cho tất cả các đối số trừ khi ngữ cảnh đã quá rõ ràng. Bao gồm tên thông số bên ngoài nếu nó làm cho việc gọi hàm dễ dàng hơn.

```swift
func dateFromString(dateString: String) -> NSDate
func convertPointAt(column column: Int, row: Int) -> CGPoint
func timedAction(afterDelay delay: NSTimeInterval, perform action: SKAction) -> SKAction!

// would be called like this:
dateFromString("2014-03-14")
convertPointAt(column: 42, row: 13)
timedAction(afterDelay: 1.0, perform: someOtherAction)
```

Đối với phương thức, theo quy ước tiêu chuẩn của Apple luôn chỉ ra các thông số đầu tiên trong tên phương thức:

```swift
class Counter {
  func combineWith(otherCounter: Counter, options: Dictionary?) { ... }
  func incrementBy(amount: Int) { ... }
}
```

### Protocols

Theo chuẩn quy ước thiết kế API của Apple, tên của một protocol nên miêu tả một cái gì đó và nên là danh từ. Ví dụ: `Collection`,` WidgetFactory`. Tên giao thức mô tả khả năng hay thời điểm có hậu tố -ing, -able, -ible hay. Ví dụ: `Equatable`,` Resizing`.

### Enumerations

Theo chuẩn quy ước thiết kế API của Apple cho Swift 3, sử dụng lowerCamelCase cho các giá trị kiểu liệt kê.

```swift
enum Shape {
  case rectangle
  case square
  case rightTriangle
  case equilateralTriangle
}
```

### Prose

Khi đề cập đến chức năng trong văn xuôi (hướng dẫn, sách, ý kiến) bao gồm các tên tham số yêu cầu từ quan điểm của người gọi hoặc `_` cho các thông số không rõ tên. Ví dụ:

> Gọi 'convertPointAt (cột: hàng:) `từ` thực hiện init` của riêng bạn.
>
> Nếu bạn gọi 'dateFromString (_ :)' chắc chắn rằng bạn cung cấp một chuỗi với định dạng "yyyy-MM-dd".
>
> Nếu bạn gọi 'timedAction (afterDelay: thực hiện:) `từ` viewDidLoad () `nhớ để cung cấp một giá trị chậm trễ điều chỉnh và một hành động để thực hiện.
>
> Bạn không nên gọi phương thức nguồn dữ liệu 'tableView (_: cellForRowAtIndexPath:) `trực tiếp.

Điều này cũng giống như 'cái selector` cú pháp #. Khi nghi ngờ, hãy nhìn vào cách Xcode liệt kê các phương pháp trong thanh nhảy - phong cách của chúng tôi ở đây phù hợp đó.

[Phương pháp trong thanh nhảy Xcode] (màn hình / xcode-nhảy-bar.png)


### Lớp Tiền tố

Kiểu trong swift được tự động xác định bởi những module chứa nó, bạn không nên thêm các lớp tiền tố như lớp RW. Nếu hai tên từ các mô-đun khác nhau xung đột nhau, bạn có thể giải quyết mập mờ bằng cách đặt trước tên kiểu với tên module. Tuy nhiên, trương hợp đó khá hiếm xảy ra.

```swift
import SomeModule

let myClass = MyModule.UsefulClass()
```

### Selectors

Selectors là phương thức obj-C mà được dùng nhiều để xử lý trong Cocoa và Cocoa Touch API. Trước Swift 2.2, chúng được xác định bằng các chuỗi an toàn. Sau swift 2.2 đã được chuyển thành cảnh báo của trình biên dịch.

** Nên: **
```swift
let sel = #selector(viewDidLoad)
```

** Không nên: **
```swift
let sel = #selector(ViewController.viewDidLoad)
```

### Generics

các tham số kiểu chung chung nên có tên gơi tả, sử dụng phong cách Upper case Camel để đặt tên. Khi một tên loại không có một mối quan hệ có ý nghĩa hoặc vai trò, sử dụng một chữ cái viết hoa đơn truyền thống như `T`,` U`, hoặc `V`.

**Preferred:**
```swift
struct Stack<Element> { ... }
func writeTo<Target: OutputStream>(inout target: Target)
func max<T: Comparable>(x: T, _ y: T) -> T
```

**Not Preferred:**
```swift
struct Stack<T> { ... }
func writeTo<target: OutputStream>(inout t: target)
func max<Thing: Comparable>(x: Thing, _ y: Thing) -> Thing
```

### Ngôn ngữ

Sử dụng chính tả tiếng Anh Mỹ để phù hợp với API của Apple.

**Nên:**
```swift
let color = "red"
```

**Không nên:**
```swift
let colour = "red"
```

## Tổ chức mã nguồn

Sử dụng tiện ích để tổ chức mã của bạn thành các khối logic chức năng. Mỗi lần gia hạn phải được đặt ra với một `// MARK: -` bình luận để giữ cho mọi thứ được tổ chức tốt.

### Protocol Conformance

 Cụ thể, khi thêm giao thức phù hợp với một model, nên thêm một mở rộng riêng biệt cho các phương thức của giao thức. Điều này sẽ giúp các phương thức liên quan được nhóm lại với nhau với các giao thức và có thể đơn giản hóa hướng dẫn để thêm một giao thức để một lớp học với phương pháp liên quan của nó.

**Preferred:**
```swift
class MyViewController: UIViewController {
  // class stuff here
}

// MARK: - UITableViewDataSource
extension MyViewController: UITableViewDataSource {
  // table view data source methods
}

// MARK: - UIScrollViewDelegate
extension MyViewController: UIScrollViewDelegate {
  // scroll view delegate methods
}
```

**Not Preferred:**
```swift
class MyViewController: UIViewController, UITableViewDataSource, UIScrollViewDelegate {
  // all methods
}
```

Bởi vì trình biên dịch không cho phép bạn khai báo lại giao thức phù hợp trong một lớp có nguồn gốc, nó không phải là luôn luôn cần thiết để nhân rộng các nhóm mở rộng của lớp cơ sở. Điều này đặc biệt đúng nếu lớp có nguồn gốc là một lớp thiết bị đầu cuối và một số lượng nhỏ các phương pháp đang được ghi đè. Khi bảo quản các nhóm mở rộng là trái với ý của tác giả.

Để xem các bộ điều khiển UIKit, xem xét nhóm vòng đời, bộ truy tùy chỉnh, và IBAction trong phần mở rộng lớp học riêng biệt.

### Mã chưa sử dụng

Chưa sử dụng (dead) code, bao gồm mã nguồn mẫu và các placeholder ​​cần được loại bỏ. Một ngoại lệ là khi hướng dẫn, hoặc cuốn sách chỉ dẫn của người sử dụng để sử dụng mã nhận xét.

phương thức hứng không trực tiếp liên quan hướng dẫn thực hiện mà chỉ đơn giản gọi là lớp siêu cũng cần được loại bỏ. Điều này bao gồm bất kỳ / phương pháp UIApplicationDelegate không sử dụng sản phẩm nào.

**Nên:**
```swift
override func didReceiveMemoryWarning() {
   super.didReceiveMemoryWarning()
  // Dispose of any resources that can be recreated.
}

override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
   // #warning Incomplete implementation, return the number of sections
   return 1
}

override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
  // #warning Incomplete implementation, return the number of rows
  return Database.contacts.count
}

```

**Không nên:**
```swift
override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
  return Database.contacts.count
}
```
### Tối thiểu hóa import

Tối thiểu hóa số lượng module cần import.

## Khoảng cách

* Thụt lề bằng 2 không gian chứ không phải là các tab để tiết kiệm không gian và giúp ngăn chặn ngắt dòng. Hãy chắc chắn để thiết lập tùy chọn này trong Xcode và trong các thiết lập dự án như hình dưới đây:

* Phương pháp niềng răng và niềng răng khác ( `if` /` else` / `switch` /` while` vv) luôn mở trên cùng một dòng như các tuyên bố nhưng gần trên một dòng mới.
* Lời khuyên: Bạn có thể tái-indent bằng cách chọn một số mã (hoặc ⌘A để chọn tất cả) và sau đó Control-I (hoặc Editor \ Cấu trúc \ Re-Indent trong menu). Một số mẫu mã Xcode sẽ có các tab 4 không gian cứng mã hóa, vì vậy đây là một cách tốt để khắc phục điều đó.

**Nên:**
```swift
if user.isHappy {
  // Do something
} else {
  // Do something else
}
```

**Không nên:**
```swift
if user.isHappy
{
  // Do something
}
else {
  // Do something else
}
```

* Cần có chính xác một dòng trống giữa các phương pháp để hỗ trợ trong sự rõ ràng trực quan và tổ chức. Khoảng trắng trong phương pháp này cần tách chức năng, nhưng có quá nhiều phần trong một phương pháp thường có nghĩa là bạn phải cấu trúc lại thành một số phương pháp.

* Dấu hai chấm luôn luôn có không gian trên bên trái và một không gian bên phải. Trường hợp ngoại lệ là các nhà điều hành ternary `? : `, Từ điển rỗng` [:] `và` # selector` cú pháp cho các thông số không rõ tên `(_ :)`.

**Nên:**
```swift
class TestDatabase: Database {
  var data: [String: CGFloat] = ["A": 1.2, "B": 3.2]
}
```

**Không nên:**
```swift
class TestDatabase : Database {
  var data :[String:CGFloat] = ["A" : 1.2, "B":3.2]
}
```

## Comments

Khi nó là cần thiết, sử dụng ý kiến ​​để giải thích lý do **tại sao** một đoạn cụ thể của mã lệnh thực hiện một cái gì đó. Ý kiến ​​phải được giữ cập nhật hoặc xóa.

Tránh khối ý kiến ​​nội tuyến với mã, như mã số nên càng tự tài liệu càng tốt. * Ngoại lệ: Điều này không áp dụng đối với những bình luận sử dụng để tạo ra tài liệu *.


## Class và Struct

### Sử dụng cái nào?

Hãy nhớ rằng, cấu trúc có [ngữ nghĩa giá trị] (https://developer.apple.com/library/mac/documentation/Swift/Conceptual/Swift_Programming_Language/ClassesAndStructures.html#//apple_ref/doc/uid/TP40014097-CH13-XID_144). Sử dụng cấu trúc cho những thứ mà không có một bản sắc. Một mảng có chứa [a, b, c] thực sự là giống như một mảng chứa [a, b, c] và họ là hoàn toàn hoán đổi cho nhau. Nó không quan trọng cho dù bạn sử dụng các mảng đầu tiên hoặc thứ hai, bởi vì họ đại diện cho một điều chính xác. Đó là lý do tại sao mảng là một cấu trúc.

Lớp có [ngữ nghĩa tham khảo] (https://developer.apple.com/library/mac/documentation/Swift/Conceptual/Swift_Programming_Language/ClassesAndStructures.html#//apple_ref/doc/uid/TP40014097-CH13-XID_145). Sử dụng các lớp học cho những điều mà không có một bản sắc hoặc một chu kỳ cuộc sống cụ thể. Bạn sẽ mô hình một người như là một lớp vì hai đối tượng người là hai việc khác nhau. Chỉ vì hai người có cùng tên và ngày sinh, không có nghĩa là họ là cùng một người. Nhưng ngày sinh của người đó sẽ là một cấu trúc bởi vì một ngày 03 tháng 3 năm 1950 cũng giống như bất kỳ đối tượng ngày khác cho ngày 03 tháng 3 năm 1950. Ngày chính nó không có một bản sắc.

Đôi khi, những điều nên được cấu trúc nhưng cần phải phù hợp với `AnyObject` hoặc được lịch sử mô hình hóa như các lớp học đã được (` NSDate`, `NSSet`). Hãy thử làm theo những hướng dẫn này là chặt chẽ nhất có thể.

### Định nghĩa Ví dụ

Dưới đây là một ví dụ về một định nghĩa lớp cũng theo kiểu:

```swift
class Circle: Shape {
  var x: Int, y: Int
  var radius: Double
  var diameter: Double {
    get {
      return radius * 2
    }
    set {
      radius = newValue / 2
    }
  }

  init(x: Int, y: Int, radius: Double) {
    self.x = x
    self.y = y
    self.radius = radius
  }

  convenience init(x: Int, y: Int, diameter: Double) {
    self.init(x: x, y: y, radius: diameter / 2)
  }

  func describe() -> String {
    return "I am a circle at \(centerString()) with an area of \(computeArea())"
  }

  override func computeArea() -> Double {
    return M_PI * radius * radius
  }

  private func centerString() -> String {
    return "(\(x),\(y))"
  }
}
```

Ví dụ trên cho thấy các hướng dẫn phong cách sau đây:

 + Xác định các loại cho các thuộc tính, các biến, hằng, khai báo đối số và báo cáo khác với một không gian sau dấu hai chấm, nhưng không phải trước, ví dụ `X: Int`, và `Circle: Shape`.
 + Xác định nhiều biến và các cấu trúc trên một dòng duy nhất nếu họ chia sẻ một mục đích chung / bối cảnh.
 + Thụt getter và setter định nghĩa và tài sản quan sát.
 + Đừng thêm bổ như `internal` khi họ đã là mặc định. Tương tự như vậy, không lặp lại các sửa đổi lần truy cập khi trọng một phương thức.


### Use of Self

Đối với súc tích, tránh sử dụng `self` từ Swift không cần nó để truy cập vào các thuộc tính của một đối tượng hoặc gọi phương pháp của nó.

Sử dụng `self` khi cần thiết để phân biệt giữa các tên thuộc tính và lập luận trong initializers, và khi tham khảo các thuộc tính trong biểu thức đóng cửa (theo yêu cầu của các trình biên dịch):

```swift
class BoardLocation {
  let row: Int, column: Int

  init(row: Int, column: Int) {
    self.row = row
    self.column = column
    
    let closure = {
      print(self.row)
    }
  }
}
```

### Thuộc tính Tính toán

Đối với súc tích, nếu một tài sản tính chỉ đọc, bỏ qua các khoản get. Các get khoản được yêu cầu chỉ khi một điều khoản thiết lập được cung cấp.

**Preferred:**
```swift
var diameter: Double {
  return radius * 2
}
```

**Not Preferred:**
```swift
var diameter: Double {
  get {
    return radius * 2
  }
}
```

### Final

Đánh dấu các lớp là 'final` khi không có ý định thừa kế. Thí dụ:

```swift
// Turn any generic type into a reference type using this Box class.
final class Box<T> {
  let value: T 
  init(_ value: T) {
    self.value = value
  }
}
```