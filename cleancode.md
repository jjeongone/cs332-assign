---
layout: post
title: "[SD] Clean Code"
date: 20220906
---
*`Thoughts` 항목은 개인적인 생각이며, 본문 또한 직접적인 번역이 아닌 주관이 들어간 각색임을 유의해 주시기 바랍니다.*

*오타나 지적은 항상 환영합니다.*

# Chapter 1. Clean Code

## There Will Be Code
우리는 code를 왜 작성하는가. Code는 어떠한 요구나 목적을 달성하기 위한 *언어*이고, 철저하고 엄격하며 정확하다는 특징을 가진다.

## Bad Code
Bad code는 코드를 짜는 순간에는 시간을 단축시키고 고민을 덜 할 수 있지만, 결과적으로 유지보수에 영향을 준다. Bad code에 의해 무언가 지연되는 것을 `wading`이라 표현한다. 아마도 대부분의 사람들은 bad code를 짜는 것을 피하고 싶어할 것이다. 하지만, 현실은 녹록치 않다. 시간적 제약, 주변의 압박, 번아웃 등 다양한 요소로 good code를 작성하는 것은 미뤄지고 bad code들만 쌓이게 된다. 

> LeBlance's law: *Later equals never*

## What Is Clean Code?
애석하게도 bad/dirty code와 clean code를 구별해낼 수 있는 능력만으로는 **clean code를 짤 수는 없다**. Clean code를 구현하기 위해서는 소소한 부분에 있어서의 technique과 상당한 공을 들여야 한다. 또한 clean code란 무엇인지에 대한 명확한 정의도 존재하지 않기 때문에, 우리는 좋은 design 방법을 고민해야 한다. 다음은 여러 프로그래머들의 clean code에 대한 철학이다.

- elegant, efficient, straightforward logic 
- simple, direct, well-written == *readability*
- clear and minimal API, can be read

## Thoughts
사실 책의 제목만 봤을 때, 그리고 'clean code를 읽으면 좋다'라는 주변의 이야기들을 들었을 때 이 책이 나에게 더 많은 것들을 줄 수 있을 것이라 생각했다. 하지만 저자들은 Conclusion 파트에서 이 책이 당신을 좋은 프로그래머로 만들어 줄 수는 없을 것이라며 *미술 책을 읽는다고 미술가가 되지는 않는다*는 말을 근거로 가져왔다. 완전히 동의하는 말이지만, 만약 내가 좋은 코드와 나쁜 코드를 구별하는 *code-sense*를 타고나지 못했다 하더라도 최소한 좋은 코드의 조건을 알고 지금까지의 내 코딩 습관을 성찰할 수 있으면 한다.

<hr>

# Chapter 2. Meaningful Names

## Use Intention-Revealing Names
직관적인 naming은 상당히 중요하다. Variable이나 function, class 등의 이름은 **왜 그것들이 존재**하고 **어떻게 사용**될 수 있는지를 드러낼 수 있어야 한다.

예를 들어 개수를 저장하는 변수에 대해 `a`와 같은 의미 없는 문자가 아니라 `num`, `number`, `count`와 같이 변수명만 봐도 어떤 역할을 하는지 알 수 있도록 해야 한다.

또한 **함수를 적절히 사용**하여 부등식이나 등호를 이용한 계산이 아닌, 어떤 조건을 검색하는 것인지를 전달할 수 있다. 다음 두 코드를 살펴보자.

```Java
public List<int[]> getFlaggedCells() {
    List<int[]> flaggedCells = new ArrayList<int[]>();
    for (int[] cell: gameBoard)
        if (cell[STATUS_VALUE] == FLAGED)
            flaggedCells.add(cell);
    return flaggedCells;
}
```

```Java
public List<int[]> getFlaggedCells() {
    List<int[]> flaggedCells = new ArrayList<int[]>();
    for (int[] cell: gameBoard)
        if (cell.isFlagged())
            flaggedCells.add(cell);
    return flaggedCells;
}
```

## Avoid Disinformation
Naming을 함에 있어 disinformation이 발생하는 경우는 다음과 같다.

- 실제 전문 용어로 사용하는 용어를 헷갈리게 사용하는 경우
  - ex. `List`구조를 사용하지 않는 group의 변수명에 'List'를 사용
- 소문자 `L`과 대문자 `o`를 변수명으로 사용하는 경우
  - ~~장난인가..?~~
- ... *무언가 세상에 다채로운 방식으로 존재*

## Making Meaningful Distinctions
Naming을 할 때 **의미 있는 단어**로 구성을 해야 한다. `a1`, `a2`, `a3`, ..., `aN`과 같은 number-series naming을 할 경우 이름을 짓기는 쉽지만 어떤 정보를 담고 있는지에 대한 정보는 전혀 들어있지 않다. 또한 불필요한 단어 사용을 주의해야 한다. 변수의 이름에 *variable*을 포함시키거나 table의 이름에 *table*을 넣는 등의 행위는 오히려 변수의 역살을 헷갈리게 만든다. **따라서 특정한 naming convention이 요구된다.**

## Use Pronounceable Names
**발음할 수 있는 단어**를 이용하여 naming을 하는 것은 소통에 있어 중요하다. 프로그래밍은 혼자서 모든 일을 해낼 수 없기 때문에 동료와 토론하는 상황이 불가피하다. 발음할 수 없는 이름을 가진 변수, 함수, 객체는 이런 상황에서 곤란함을 가져다 준다.

## Use Searchable Names
**검색 가능한** naming을 하는 것 또한 고려해야 하는 부분이다. 프로젝트가 커질수록 어느 파일에 어느 함수가 있는지 완벽히 파악하기 어려워지고, IDE에 포함된 검색 기능을 사용하게 된다. 만약 변수명이 `e`와 같이 영어에서 흔하게 사용되는 문자일 경우, 필요한 내용까지 도달하는 데에 오랜 시간과 노력이 필요하다.

## Avoid Encodings
축약어나 특정한 방식으로 encoding한 변수명을 사용하는 것은 개발자로 하여금, 특히 신입 개발자에게, 부담을 줄 수 있다. 동시에 발음이 어렵거나 오타를 내기 쉽다는 단점이 있다.

## Hungarian Notation
초기 Windows C API를 구성함에 있어 HN(Hungarian Notation)은 상당히 중요한 역할을 하였다. HN은 compiler가 type check를 수행하지 않기 때문에, 이름을 통해 type을 파악할 수 있는 *type에 따른 명명법이나 prefix*를 의미한다. 시간이 흐름에 따라 다양한 언어나 IDE에서 compile을 하기 전에 type check를 수행할 수 있게 되면서 HN은 오히려 코드를 읽기 어렵게 하고, type이 바뀔 때마다 변수명을 바꿔야 하는 불편함이 있기 때문에 이제는 사용하지 않는 방식이다.

요즘의 트랜드는 **더 작고 간결한 class, function**을 통해 각 변수들이 어떤 역할을 하는지 한눈에 알기 쉽도록 하는 것이다.

## Avoid Mental Mapping
Mental mapping이라 하면, 코드를 읽고 이해하는 데에 필요한 정신력을 말한다. 이는 `i`, `j`, `k`와 같은 (앞서 말했듯 소문자 `L`은 변수명으로는 부적합하다) single-letter variable name을 사용할 때 빈번하게 발생한다. *Smart programmer*과 *professional programmer*의 차이는 간결하고 명료한 코드의 중요성을 아는지에 따라 달려있다. 당연히 professional programmer 쪽이 **다른 사람들이 이해하기 쉬운 코드**의 중요성을 알고 있다.

## Class Names
Class의 이름을 정할 때에는 `Manager`, `Processor`, `Data`, `Info`와 같은 다른 기본 function에서 자주 쓰는 단어나 *verb*를 피하고, `Customer`, `WikiPage`, `Account`와 같은 ***noun***이나 ***noun phrase***를 사용해야 한다.

## Method Names
Method의 이름은 `postPayment`, `deletePage`, `save`와 같은 ***verb***나 ***verb phrase***를 사용해야 한다. 또한 `get`, `set`, `is`와 같은 prefix를 사용함으로써 method의 기능을 파악하기 쉽다.

**Static factory method**를 사용하면, `new`를 통해 객체를 생성하는 방식에 비해 더 직관적으로 코드를 이해할 수 있다. 다음 코드를 통해 살펴보자.

```Java
Complex fulcrumPoin = Complex.FromRealNumber(23.0);
```

```Java
Complex fulcrumPoint = new Complex(23.0);
```

## Don't Be Cute
Naming을 하다 보면 *재치있고 창의적인* 이름을 짓고 싶을 때가 있을 수도 있다. 특히 *구어적 표현*이나 *은어*, *culture-dependent joke*를 사용하면 해당 문화를 공유하는 사람들끼리는 즐거움을 줄 것이다. 이 책에 나온 예시는 특히 영어권이 아닌 우리 ~~(나만 그럴 수도..)~~ 들에게 좋은 예이다. `whack()`이나 `eatMyShorts()`라는 이름을 가진 함수가 어떤 기능을 하는지 직관적으로 알 수 있는가? 구글 번역기에 따르면 `whack`은 *구타*이고, `eat my shorts`는 심지어 1980년대에 나온 영화에서 생겨난 meme으로 상대방의 말에 *경멸*, *반박*, *거부*하는 맥락에서 사용되는 말이다. 자, 모두가 알아들을 수 있는 말을 사용하도록 하자.

## Pick One Word per Concept
Naming을 함에 있어 어휘를 통일시켜야 한다. 만약 서로 다른 class에서 `get`, `fetch`, `retrieve`라는 이름을 가지는 함수가 있다고 하자. 이들이 같은 기능을 하는지, 어떤 class에서 어떤 이름을 사용했는지 모두 외우기는 불가능하다. 최근 IDE인 *Eclipse*나 *IntelliJ*는 context에 맞는 method들의 list를 제공해 주지만, 이것에 의존해서는 안된다. **한결같은 어휘**는 당신의 코드를 읽어야 하는 누군가에게 도움이 된다.

## Don't Pun
같은 단어를 두 가지 유사한 기능에서 사용하지 않도록 하자. 이는 앞서 설명한 *"one word for concept"* 를 수행함에 있어 발생하기 쉬운 실수이다. 예를 들어 지금까지 `add`라는 함수를 *새 변수를 추가하거나 두 값을 합치는 기능*을 수행하도록 구성하였다고 하자. 만약 *새 변수를 추가*하는 기능만을 가지는 함수를 새로 만든다면, `add`라는 이름을 사용해도 되는가? **안 된다.** 유사해 보이지만 둘의 기능은 명확히 다르고, 코드를 사용하는 사람의 입장에서 헷갈림을 줄 수 있다. `insert`나 `append`라는 다른 어휘를 사용하면 이를 해결할 수 있다. *읽기 쉬운 코드를 작성하는 것은 중요하다.*

## Use Solution Domain Namaes
사실, 당신이 쓰는 코드를 읽는 사람은 높은 확률로 ~~(아마 확실히)~~ 프로그래머일 것이다. 이는 당신이 선택하는 어휘가 꼭 이해하기 쉬운 말일 필요는 없다는 뜻이다. 아마도 이들은 *computer science terms*, *algorithm terms*, *pattern names*, *math terms*와 같은 전문 용어를 어렵지 않게 이해할 수 있을 것이다.

## Use Problem Domain Names
만약 당신 주변에 프로그래머들이 없다면, problem domain names를 사용하는 것을 권장한다.

~~(사실 이 부분은 잘 이해가 되지 않음. 그냥 문제 상황에서 쓰이는 용어를 사용하면 좀 더 직관적일 수 있다는 말일까?)~~

## Add Meaningful Context
만약 `firstName`, `lastName`, `street`, `houseNumber`, `city`, `state`, `zipcode`와 같은 변수들이 있다고 생각해 보자. 그렇다면 이들이 주소를 나타내는 변수라는 것을 쉽게 파악할 수 있을 것이다. 그렇다면 만약 `state`만 있다면, 과연 이 변수가 어떤 정보를 저장하는지 맥락을 쉽게 파악할 수 있을까?

이를 쉽게 해결하는 방법은 *의미 있는 prefix*를 추가하는 것이다. `addr`이라는 prefix를 추가하면, 쉽게 주소를 나타냄을 알 수 있다. 혹은 `Address`라는 이름을 가지는 class의 하위에 변수를 저장하면, 사람은 물론이고 compiler 또한 의미를 알 수 있게 된다.

하지만 아무리 맥락 정보를 충분히 제공한다고 하더라도 함수가 너무 길고 복잡하면 어떤 기능을 하는지 쉽게 파악하기 힘들다. 물론 함수명을 통해 어떤 기능을 수행하는지 추정할 수는 있지만, 내부 코드를 읽고 디버깅 해야 하는 상황에는 부적합하다. 이를 해결하기 위해서는 *sub-function*을 분리하여 조건문이나 특정 연산이 어떤 기능을 하는지를 명확히 할 수 있다.

## Don't Add Gratuitous Context
하지만! 동시에 너무 과한 맥락 정보를 naming에 사용하는 행위는 자제해야 한다. 이름은 직관적이고 의미를 잘 전달해야 하지만, 동시에 **간결**해야 하기 때문이다.

## Thoughts
당연하다고 생각했던 내용, 경험적으로 불편하게 느꼈던 방식(소문자 `L`을 변수명으로 사용하는 것)을 포함하여 코딩을 함에 있어 *가장 기초*라고 할 수 있는 이름 짓기에 대해 고민을 해볼 수 있는 장이었다. 또한 모든 꼭지들에서 **남들이 읽기 쉽고, 이해하기 쉬운 코드**에 대한 강조를 강하게 하고 있었다. 사실 대학교에서 과제를 할 때에는 보통 개인 과제이고, 팀프로젝트를 하더라도 규모가 그렇게 크지는 않기 때문에 코드를 작성함에 있어 readability를 고려할 필요성이 거의 없었다. 현재로써는 과거에 작성한 코드를 봐야 할 일이 거의 없지만, 앞으로라도 미래의 나를 위해 좀 더 신경써서 코딩을 해야 겠다는 생각이 들었다.

<hr>

# Chapter 3. Functions
초기 프로그래밍에서는 *routines*나 *subroutines*의 개념을 사용하여 system을 구성하였다. 이후 *programs*, *subprograms*, *functions*의 개념이 나타났고, 이들 중 *function*만이 현재 살아남아 사용되고 있다.

함수를 잘 사용하면 코드를 보다 이해하기 쉽게 해주고, 의도를 직관적으로 이해할 수 있게 해준다. 그렇다면, 함수를 **잘**사용한다는 것은 어떤 것일까?

## Small!
명확히 증명할 수는 없지만, function은 항상 **작은 것**이 좋다. 함수에 대한 첫 번째 규칙은 작아야 하는 것이고, 두 번째 규칙은 *그것보다 더 작아야* 한다는 것이다! 

작은 함수는 얼마나 작아야 할까? 다음 두 함수를 살펴보자.

```Java
public static String renderPageWithSetupandTeardowns(PageData pageData, boolean isSuite) throws Exception {
    boolean isTestPage = pageData.hasAttribute("Test");
    if (isTestPage) {
        WikiPage testPage = pageData.getWikiPage();
        StringBuffer newPageContent = new StringBuffer();
        includeSetupPages(testPage, newPageContent, isSuite);
        newPageContent.append(pageData.getContent());
        includeTeardownPages(testPage, newPageContent, isSuite);
        pageData.setContent(newPageContent.toString());
    }
    return pageDate.getHtml();
}
```

```Java
public static String renderPageWithSetupandTeardowns(PageData pageData, boolean isSuite) throws Exception {
    if (isTestPage(pageData))
        includeSetupAndTeardownPages(pageData, isSuite);
    return pageData.getHtml();
}
```

둘 중 하나를 선택하라고 한다면, 당연히 후자일 것이다. 놀라운 점은 전자 또한 refactoring을 거친 version이라는 것이다. 두 번째 code-block은 첫 번째 code-block의 refactoring version으로 원본 코드에 대한 *re-refactoring version*이라 할 수 있다. **함수를 줄이는 데에 한계란 없다**. ~~(함수가 존재하는 선에서 말이다)~~

### Blocks and Indenting
`If-else`문이나 `while`문은 한 줄 정도가 적당하다. 조건을 검사할 때 보통 어떤 연산을 수행하게 되는데, 이를 적절한 함수를 통해 실행하면 조건문에 대한 *documentation* 효과를 볼 수 있다.

## Do One Thing
함수에 대한 강력한 조언은 다음과 같다.
> Functions should **do one thing**. They should **do it well**. They should **do it only**.

그렇다면, 여기서 강조하는 **one thing**이란 무엇일까. 단 하나의 기능(예를 들면 비교)만을 수행해야 하는 것일까? 그렇지 않다. 함수를 *여러 step*으로 구성될 수 있으며, 이 step들이 모여 수행하는 기능을 한 문장으로 요약할 수 있다면 하나의 기능이라고 볼 수 있다.

## One Level of Abstraction per Function
### Reading Code from Top to Bottom: *The Stepdown Rule*
사람들은 code를 위에서 아래로 읽어 내려가는 흐름대로 이해하고 싶어할 것이다. 이를 *The Stepdown Rule*이라 부르고, 저자들은 *TO* paragraph을 읽는 순서와 동일한 흐름이라고 서술한다. 한국어로는 `~하기 위해 -를 한다`정도로 이해를 하면 쉽다.

이런 흐름을 유지하면서 코드를 작성하기는 쉽지 않지만, 함수가 **do one thing**을 유지하는 데에는 효율적이다.

## Swith Statement
~~*(뭔가 읽어도 이해가 잘 안되는 파트인데 Java를 잘 몰라서인지 내가 이해를 못한것인지)*~~

**Do one thing**을 하지 않는 대표적인 예시로 `switch`문이 있다. 보통 ~~(어쩌면 항상)~~ `switch`문은 *do N things*를 수행한다.

다음과 같은 `switch`문을 사용하는 프로그램이 있다고 할 때 이의 한계점은 아래와 같다.

```Java
public Money calculatePay(Employee e)
throws InvalidEmployeeType {
    switch (e.type) {
        case COMMISSIONED:
            return calculateCommissionedPay(e);
        case HOURLY:
            return calculateHourlyPay(e);
        case SALARIED:
            return calculateSalariedPay(e);
        default:
            throw new InvalidEmployeeType(e.type);
    }
}
```

1. 새로운 employee type이 추가되면 `switch`문은 더 길어질 것이다
2. **Do *not* one thing**임이 확실하다
3. Single Responsibility Principle (SRP)를 위반한다
4. Open Closed Principle (OCP)를 위반한다

이러한 문제를 해결하기 위한 방법은 다음과 같다. `switch`문을 *abstract factory*에 넣어 사용자로 하여금 보이지 않게 한다. 이 `switch`문은 employee에 따른 적절한 수행을 matching시키는 데에 사용된다.

```Java
public abstract class Employee {
    public abstract boolean isPayday();
    public abstract Money calculatePay();
    public abstract void deliverPay(Money pay);
}

public interface EmployeeFactory {
    public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
}

public class EmployeeFactoryImpl implements EmployeeFactory {
    public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {
        switch (r.type) {
            case COMMISSIONED:
                return new CommissionedEmployee(r);
            case HOURLY:
                return new HourlyEmployee(r);
            case SALARIED:
                return new SalariedEmployee(r);
            default:
                throw new InvalidEmployeeType(r.type);
        }
    }
}
```

## Use Descriptive Names
함수의 이름을 정하는 것은 중요하다. 다양한 후보 중에서 함수의 기능을 가장 잘 설명할 수 있는 이름을 선택해야 한다. *clean code*의 절반은 **do one thing**을 하는 작은 함수를 설명할 수 있는 이름을 짓는 것이다. 좋은 이름을 찾기 위한 조언은 다음과 같다.

- **긴 이름에 대한 두려움**을 버려라: 설명을 잘 할 수 있는 긴 이름은 수수께끼같은 짧은 이름보다 훌륭하다. 긴 descriptive name은 긴 descriptive comment보다 좋다.
- 이름을 정하는 데 **긴 시간**을 투자하는 것을 당연시해라: 다양한 이름을 코드에 적용시켜 보고, 제일 적합한 이름을 찾아가는 것을 추천한다. 제공되는 IDE의 기능을 활용하면 편하게 refactoring할 수 있다.
- **어휘를 통일**시켜라: Chapter 2의 *Pick One Word per Concept*에서도 강조한 바 있듯, 같은 *phrase*, *nouns*, *verbs*를 이용하여 이름을 지어야 나중에 코드를 읽고 이해하기 쉽다.

## Function Arguments
적절한 함수 인자의 수는 몇 개일까? 이상적인 함수 인자 수는 0개이다. 1개나 2개, 3개까지는 특수한 경우에 용인되지만, 그 이상은 지양해야 한다. 함수 인자 수가 적어야 하는 이유는 함수 인자의 수가 늘어남에 따라 computing power가 많이 들고, test를 하기 어려워지기 때문이다. 최대한 직관적인 함수를 구성하기 위해 **가능한 적은 수의 인자**를 받도록 설계해야 한다.

### Flag Arguments
함수의 인자로 `boolean`값을 넘겨주는 것은 최악이다. 왜냐하면 `boolean`값을 인자로 받는다는 의미는, T/F 여부에 따라 다른 행위를 한다는 뜻이기 때문에 **do one thing**을 위반한다.

### Dyadic Functions
인자가 2개인 함수는 인자가 1개인 함수에 비해 함수의 기능을 직관적으로 이해하기 어렵다. 예외적인 상황이 있는데, 시간을 나타내는 함수이다. 시간과 분을 각각 입력받는 함수는 인자가 두개일 수밖에 없고, 동시에 직관적으로 확실하다. 하지만 실제로 이 *시간*이라는 개념은 하나의 값이고, 이를 순차적으로 서술한 것이기 때문에 single argument와 다를 바 없다. 만약 *monad*와 *dyadic* 중 선택하여 설계할 수 있다면 computing cost와 advantage에서 오는 cost를 잘 따져봐야 한다.

### Argument Objects
만약 어떤 함수가 3개 이상의 인자를 필요로할 때에는 그 인자들의 일부를 object로 받아야 하는 경우가 빈번하다. 예를 들어 다음과 같은 함수 정의가 있다고 하자. 직관적으로 두 번째 함수가 기능을 설명하는 데에 더 명확하다.

```Java
Circle makeCircle(double x, double y, double radious);
Circle makeCircle(Point center, double radious);
```

### Verbs and Keywords
좋은 함수명과 인자명 ~~(함수 인자의 이름)~~ 은 **함수의 기능을 설명**하는 데 도움을 준다. 예를 들어 `writeField(name)`이라는 함수가 존재한다면, 이는 직관적으로 name을 write하는 함수인데 이 name이 field와 관련되어 있다는 것을 알 수 있다.

## Have No Side Effects
함수를 실행하였을 때 side effects가 없도록 하는 것은 **do one thing**을 지키는 데에 필수적이다. 의도치 않은 변화가 발생하면, 사용자가 의도한 대로 code가 작동하지 않을 수 있다. 만약 한 함수에서 두 가지 일을 하고 싶으면, 그 둘을 모두 포함하는 naming을 하여 사실상 하나의 기능을 하는 함수를 구성해야 한다.

## Command Query Seperation
함수는 보통 *무언가를 수행*하거나 *무언가에 대답*하는 기능을 수행하는데, 이 둘을 동시에 하지 않아야 한다. 

## Prefer Exceptions to Returning Error Codes
Command 함수(무언가를 수행하는 함수)에서 error code를 반환하는 것은 *Command Query Seperation*을 위반하는 좋은 예시이다. `if-else`문을 통해 error code를 처리하는 것은 각각의 case마다 검사하는 logic을 구성해야 해서 code가 복잡해질 수 있는 반면, exception(`try/catch`문)을 사용하면 보다 간결하게 code를 구성할 수 있다.

```Java
try {
    deletePage(page);
    registry.deleteReference(page.name);
    configKeys.deleteKey(page.name.makeKey());
}
catch (Exception e) {
    logger.log(e.getMessage());
}
```

### Extract Try/Catch Block
`try/catch`문을 깔끔하게 작성하는 방법은, 기능을 분리하는 것이다. 위의 *Prefer Exceptions to Returning Error Codes*에서 구현된 code는 `try/catch`문 안에 함수의 기능이 포함되어 있어 자칫 code의 구조를 이해하기 어려워질 수 있다. 이는 다음과 같은 방식으로 code를 작성하면 해결된다.

```Java
public void delete(Page page) {
    try {
        deletePageAndAllReferences(page);
    }
    catch (Exception e) {
        logError(e);
    }

    private void deletePageAndAllReferences(Page page) throws Exception {
        deletePage(page);
        registry.deleteReference(page.name);
        configKeys.deleteKey(page.name.makeKey());
    }

    private void logError(Exception e) {
        logger.log(e.getMessage());
    }
}
```

### Error Handling Is One Thing
**Error handling**은 **one thing**이다. 즉, error handling을 수행하는 `try/catch`, `try/finally`문 뒤에는 다른 기능을 하는 code가 와서는 안된다.

## Structured Programming
> Dijkstra's Rules of Structured Programming: every function, and every block within a function, should have one entry and one exit.

위의 *Dijkstra's Rule of Structured Programming*이 의미하는 바는, 함수에서는 단 하나의 `return`이 존재해야 하고, loop에서 `break`이나 `continuous`가 등장하지 않아야 하며, `goto`문은 사용해선 안된다는 뜻이다.

*Structured programming*을 하면 좋지만 우리의 목표는 어디까지나 작고 명확한 함수를 만드는 것이기 때문에, 이를 달성하기 위해 적절한 곳에서 `return`을 여러번 하거나 `break` 혹은 `continuous`를 사용하는 것은 적절하다. 하지만 여전히 `goto`문을 사용하는 것은 작은 함수를 만드는 데에 걸림돌이 되기 때문에 피해야 한다.

## How Do You Write Functions Like This?
**소프트웨어를 작성한다는 것은 여타 다른 글을 작성하는 것과 동일하다**. 우리는 글을 쓸 때 처음에는 두서없이 생각을 뱉어낸 후, 이를 다음고 정리하여 글을 완성한다. 함수를 작성할 때에도 마찬가지이다. 처음에는 길고, 인자의 수도 많으며, 추상적인 이름들을 가지지만, 이를 바탕으로 *여러 함수로 쪼개고*, *이름을 적절하게 수정하고*, *반복되는 부분을 삭제*하는 등 함수를 다듬는 과정을 거친다.

## Thoughts
지난 *Chapter 2*에 비해 더 많은 자아성찰의 시간을 가지게 한 장이었다. 함수를 쓰는 목적이 기능을 분리하고 재사용성을 높이는 데에 있다는 수박 겉핥기 식의 개념만 알고 있었지, 함수의 개념이 이렇게까지 고도화되어 있을 것이라 생각하지 못하였다. 지금까지 내가 만든 함수들의 추상적인 이름과 수많은 인자들이 조금은 부끄러울 지도 모르겠다. 적절한 `try/catch`문의 사용도 실제 코딩을 통해 배우고 싶고, 함수의 인자를 최적화해가는 과정도 경험하고 싶다. 

사실 refactoring에 대한 은연중의 망설임이 있었다. 지금까지는 단발적으로 사용하는 코드들을 짜오다 보니 형태가 마음에 들지 않아도 기능만 잘 하면 된다는 생각이 강했는데, 이렇게 어물쩡 넘겨버린 좋은 코드를 연습할 수 있는 기회를 앞으로는 놓치지 않으려고 한다.

적절한 이름을 위한 고민은 끝이 없을 것 같다.

<hr>

# Chapter 4. Comments
Comment의 존재는 필요악이라고 할 수 있다. 만약 우리가 적절하게 프로그래밍 언어를 사용하여 의미가 통하는 코드를 짠다면, comment는 필요없기 때문이다.

강조하건데, comment는 가능한 사용하지 않는 편이 최선이다.

Comment에 대한 평이 이렇게 박한 이유는, comment는 늘 코드를 잘 설명하지 못하기 때문이다. 처음 코드를 짜고 comment를 작성하였을 때에는 둘의 의미가 같을지도 모른다. 하지만, 시간이 지남에 따라 코드는 변화하는데 이 변화에 맞춰 comment까지 정확히 변화할지는 장담할 수 없다. ***오로지 우리가 신뢰할 수 있는 정보는 코드 뿐이다.***

## Comments Do Not Make Up for Bad Code
구현한 코드가 복잡하고 난해하다고 생각될 때 우리는 comment를 잘 작성하여 이를 무마하려고 한다. Comment를 잘 작성하기 위해 노력하는 시간을 code refactoring에 투자하는 것이 더 좋은 코드를 작성하는 길이다.

## Explain Yourself in Code
코드가 스스로의 기능을 잘 설명하지 못한다는 것은 착각이다. 다음 두 예시를 살펴보자. Raw한 코드와 주석을 읽는 것보다 길지만 잘 naming된 함수명을 읽는 편이 더 직관적이다.

```Java
// Check to see if the employee is eligible for full benefits
if ((employee.flags & HOURLY_FLAG) && (employee.age > 65))
```

```Java
if (employee.isEligibleForFullBenefits())
```

## Good Comments
간혹 comment가 유용한 경우가 있다. 하지만 기억해야 하는 것은 여전히 comment를 쓰지 않는 것이 최선이라는 사실이다.

### Legal Comments
Copyright이나 Authorship과 같이 타당하고 필요한 내용은 comment에 담겨도 된다 ~~(담겨야 한다)~~.

### Informative Comment
정보를 담고 있는 comment는 다음과 같은 예시가 있다.
```Java
// Returns an instance of the Responder being tested.
protected abstract Responder responderInstance();
```
함수가 어떤 값을 return해주는지 comment를 통해 알려주는 방식은 유용하지만, 여전히 함수명에 기능을 녹여내는 편이 더 좋다. 예를 들어 위의 함수명을 `responderBeingTested`로 바꿀 수 있다.

```Java
// format matched kk:mm:ss EEE, MMM dd, yyyy
Pattern timeMatcher = Pattern.compile(
    "\\d*:\\d*:\\d* \\w*, \\w* \\d*, \\d*");
```
위의 경우 어떤 format으로 값을 받는지 comment를 통해 알 수 있기 때문에 유용하다.

### Explanation of Intent
코드를 왜 그렇게 작성할 수밖에 없었는지 구성할 당시의 의도를 파악할 수 있는 comment는 다른 사람으로 하여금 코드를 이해하는 데에 도움을 준다.

### Clarification
Argument나 return값이 모호할 때에는 comment를 통해 확실히 하는 것이 도움이 된다. 처음부터 모호하지 않도록 코드를 짜면 좋지만, 외부 라이브러리를 import해서 쓰거나 수정할 수 없는 코드일 경우 comment를 사용하면 좋다.

### Warning of Consequences
Comment는 때로 코드 실행 결과에 대한 warning을 할 때 쓰인다. 예를 들어 다음과 같은 예시가 있다.

```Java
// Don't run unless you have some time to kill
public void _testWithReallyBigFile() {
    ...
}
```
요즘에는 `@Ignore` 테그를 통해 `@Ignore("Takes too long to run")`와 같이 적절한 설명을 할 수 있다. 

### TODO Comments
`//TODO` comment를 통해 *모종의 blocker*로 인해 진행되지 못한 부분에 대해 reminder를 하고  앞으로 해당 함수/코드가 어떤 기능을 하게 될 것인지를 명시할 수 있다. 

```Java
//TODO-MdM these are not needed
// We expect this to go away when we do the checkout model
protected VersionInfo makeVersion() throws Exception
{
    return null;
}
```

### Amplification
Comment는 다른 사람들에게는 중요해 보이지 않는 부분에 대한 강조를 하는 역할을 하기도 한다.
```Java
String listItemContent = match.group(3).trim();
// the trim is real important. It removes the starting
// spaces that could cause the item to be recognized
// as another list.
...
```

## Bad Comments
대부분의 comment들이 이 category에 해당한다. Bad comment들은 대게 적절하지 못한 결정이나 구린 코드를 정당화하는 데 사용되지 때문에 피해야 한다.

### Mumbling
만약 comment를 작성하기로 마음먹었다면, 심혈을 기울여 최선의 comment를 작성해라.
### Redundant Comments
Comment가 오로지 코드에 작성되어 있는 내용을 그대로 서술하는 것은 낭비이다. 오히려 길고 구어적인 comment가 코드보다 읽기 어려울 수 있다.
### Misleading Comments
잘못 읽혀 오해의 소지가 있는 comment를 작성하지 않도록 주의하자.
### Mandated Comments
모든 변수나 함수에 comment를 달아야 한다고 생각하지 말아라.
### Journal Comments
모든 변화가 일어날 때 마다 일기 쓰듯이 일일히 주석을 다는 행위는 불필요하다.
### Don't Use a Comment When You Can Use a Function or a Variable
Comment에 작성된 내용을 function이나 variable을 통해 구현한 예시는 다음과 같다.
```Java
// does the module from the global list <mod> depend on the subsystem we are part of?
if (smodule.getDependSubsystems().contains(subSysMod.getSubSystem()))
```
```Java
ArrayList moduelDependees = smodule.getDependSubSystems();
String ourSubSystem = subSysMod.getSubSystem();
if (moduleDependees.contains(ourSubSystem))
```
### Position Markers
Comment를 이용하여 특정한 위치를 알리는 marker를 만들고 싶을 수는 있지만, 보통은 거추장스럽고 제 기능을 하지 못한다.
### Closing Brace Comments
중괄호가 끝나는 부분에서 어느 문(state)인지를 나타내는 주석을 달면 읽기 편할 수는 있지만, 차라리 코드를 간결하게 짜는 편이 좋다.
### Attributions and Bylines
누가 작성한 코드인지 명시해두면 질문을 할 때 유용할 수는 있지만, 코드는 변화하고 사람도 유동적이기 때문에 비효율적이다. (git을 쓰면 누가 수정했는지 알 수 있으니 코드에 명시하는건 정말 별로인듯?)
### Commented-Out Code
주석처리된 코드를 남겨두지 말아라. 누군가 주석 처리된 코드를 본다면 필요한 코드인지 그렇지 않은지 알 수 없기 때문에 차마 건드리지 못할 것이다.(옛날에는 필요했을 수도 있지만 지금은 전혀 아니다)
### HTML Comments
HTML로 작성된 comment는 programmer가 읽기에는 최악이다. 어떤 program이나 IDE를 거쳐 읽기 쉽게 반환되는 경우에는 몰라도, 사람이 읽을 것이 못된다.
### *TMI(Too Much Information)*

## Thoughts
주석이 없는 코드가 좋은 코드라는 말은 컴공 전공을 선택한 이후로 늘 듣고 있는 말이지만, 이렇게까지 주석을 싫어하는 글은 처음이었다. 주석이 귀가 있다면 귀를 막고 눈이 있다면 눈을 가려주고 싶을 정도로..😶

사실 1, 2학년때 들었던 전공 과목들에서는 주석을 필수적으로 작성하도록 하였다. 어느 정도로 자세히 적어야 감점이 되지 않을까 노심초사하며 잔뜩 주저리 적었던 기억이 나는데, 사실 감점되지 않기 위해서는 간결한 주석을 작성했어야 했을지도 모르겠다.

Naming의 중요성과 이렇게까지 긴 이름을 변수/함수명으로 정해도 되는지를 몰랐을 때에는 어떻게 주석이 없는 코드를 읽고 직관적으로 바로 이해할 수 있는지 의문이었는데, 적절한 naming이 갖추어져 있다면 충분히 readable한 코드를 짤 수 있을 것이라는 생각이 든다.

본문에도 나와있지만, **format**을 명시하는 주석은 중요한 요소라고 생각된다. Backend API를 짤 때 어떤 형식으로 값이 들어와야 하는지를 명시하지 않아 의도하지 않은 값이 들어와 문제가 발생한 경험이 있어 더욱 공감되었던 것 같다. 

~~사실 어쩌면 Good Comments까지만 읽고 그 외의 주석은 달면 안되는구나~ 하고 생각하고 넘어가도 괜찮았을 것 같기도 하다.~~

<hr>

# Chapter 5. Formatting

<hr>

# Chapter 6. Object and Data Structure

<hr>

# Chapter 7. Error Handling

적절한 error handling을 통해 더 우아하고 탄탄한 코드를 구성할 수 있다.

## Use Exceptions Rather Than Return Codes
보통 각각의 조건을 검사하고 error handling을 수행하는 방식으로 코드를 구성하는데, 이렇게 구성하였을 때의 한계는 logic이 지나치게 길어지거나 까먹을 수 있다는 점이다. 다음 두 예시를 살펴보자.

```Java
public class DeviceController {
    ...
    public void sendShutDown() {
        DeviceHandle handle = geHandle(DEV1);
        // Check the state of the device
        if (handle != DeviceHandle.INVALID) {
            // Save the device status to the record field
            retrieveDeviceRecord(handle);
            // If not suspended, shut down
            if (record.getStatus() != DEVICE_SUSPENDED) {
                pauseDevice(handle);
                clearDeviceWorkQueue(handle);
                closeDevice(handle);
            } else {
                logger.log("Device suspended. Unable to shut down")l
            }
        } else {
            logger.log("Invalid handle for: " + DEV1.toString());
        }
    }
}
```

```Java
public class DeviceController {
    ...
    public void sendShutDown() {
        try {
            tryToShutDown();
        } catch (DeviceShutDownError e) {
            logger.log(e);
        }
    }

    private void tryToShutDown() throws DeviceShutDownError {
        DeviceHandle handle = getHandle(DEV1);
        DeviceRecord record = retrieveDeviceRecord(handle);

        pauseDevice(handle);
        clearDeviceWorkQueue(handle);
        closeDevice(handle);
    }

    private DeviceHandle getHandle (DeviceID id) {
        ...
        throw new DeviceShutDownError("Invalid handle for: " + id.toString());
        ...
    }
    ...
}
```

## Write Your `Try-Catch-Finally` Statement First
Exception을 처리함에 앞서 `try-catch-fianlly`문을 기본으로 코드를 구성하면 좋다. 특히 `catch`문에서 특정한 type의 error를 받도록 처리하면 더 직관적인 코드를 작성할 수 있다.

## Provide Context with Exceptions
Error message를 작성할 때 충분한 정보를 담은 message를 작성하여 어떤 맥락에서 발생시키는 error인지를 알 수 있도록 한다.

## Define the Normal Flow
적절한 위치에 error handling logic을 배치하여 의도하지 않은 상황을 예방하는 것은 좋다. 하지만, 다음과 같은 경우는 어떨까.

```Java
try {
    MealExpenses expenses = expenseReportDAO.getMeals(employee.getID());
    m_total += expenses.getTotal();
} catch(MealExpensesNotFound e) {
    m_total += getMealPerDiem();
}
```

`catch`문으로 error 상황을 받아 다른 연산을 수행한다는 것이 이상하게 느껴질 것이다. 위의 코드는 다음과 같이 수정할 수 있다.

```Java
MealExpenses expenses = expenseReportDAO.getMeals(employee.getID());
m_total += expenses.getTotal();
```
여기서 더 간결하고 깔끔한 코드를 작성하는 방법은 없을까? **SPECIAL CASE PATTERN**이라고 부르는 class를 통해 해결할 수 있다.

```Java
public class PerDiemMealExpenses implements MealExpenses {
    public int getTotal() {
        // return the per diem default
    }
}
```

## Don't Return Null
코드를 구성함에 있어 `Null`을 return하지 않도록 짜야 한다. `Null`을 return하는 함수나 method가 있다면, 해당 함수/method를 호출하는 모든 곳에서 null check을 해줘야 하기 때문에 `Null` 사용을 최소화 해야한다. 다음 예시를 살펴보면 어떻게 `Null` 사용을 최소화할 수 있는지 감이 올 것이다.

```Java
List<Employee> employees = getEmployees();
if (employees != null) {
    for(Employee e : employees) {
        totalPay += e.getPay();
    }
}
```

```Java
public List<Employee> getEmployees() {
    if (no employees) {
        return Collections.emptyList();
    }
} 

List<Employee> employees = getEmployees();
for (Employee e : employees) {
    totalPay += e.getPay();
}
```

## Don't Pass Null
`Null`을 return하는 것은 안좋지만, `Null`값을 passing하는 것은 더 안좋다. 함수의 인자나 method의 결과로 `Null` 값을 넘겨주면, 해당 값을 사용할 때 null check을 수행해야 한다. 적절한 error handling을 통해 run time error를 막을 수는 있지만, 애초에 `Null`을 넘겨주지 않는다면 error handling을 신경쓰지 않아도 되고 코드 또한 간결해진다.

## Thoughts
`try-catch-finally`문을 이용하여 error handling을 수행한다는 것은 알고 있었지만, 사실 지금까지 코딩을 하면서 error handling을 신경써본 경험이 잘 없어 이전 Chapter들에 비해 덜 감명깊었던 것 같다. 거의 backend 코드를 짤 때에만 `try-catch`문을 사용해봤던 것 같은데, 이렇게 logging이나 중단되지 않고 계속 실행되는 것이 중요한 production code를 작업할 때에는 필수적으로 가능한 error들에 대한 handling을 꼼꼼하게 수행해야겠다는 생각이 들었다.

<hr>

# Chapter 9. Unit Tests

Chapter에 들어가기에 앞서 `Agile`과 `TDD`의 개념을 먼저 정리하고자 한다.

### Agile
> 1. 날렵한, 민첩한(=nimble) 2. (생각이) 재빠른, 기민한

사전적 의미에서 알 수 있듯, agile은 짧은 주기의 계획을 통해 하나의 큰 프로젝트를 완성해 나가는 과정을 말한다. Agile을 성공적으로 실행하기 위해서는 동료간의 적극적인 피드백과 소통이 중요하기 때문에, kanban보드를 사용하거나 daily scrum, weekly scrum 등을 도입하기도 한다.

### TDD(Test Driven Development)

Agile을 달성하기 위한 방법론 중 하나로, **테스트 케이스를 먼저 작성**하고 이를 달성할 수 있는 코드를 짜는 개발 방식을 말한다.

## The Tree Laws of TDD
TDD를 수행하기 위해 지켜야 하는 3가지 법칙은 다음과 같다.

1. Failing unit test를 작성하기 전까지 production code를 작성해서는 안된다.
2. 불필요할 정도로 많은 unit test를 작성할 필요는 없다.
3. Test를 통과하기 충분한 production code를 작성하면 된다. (== test에서 요구하는 것보다 많은 양을 개발하지 않아도 된다)

이를 지켰을 때 우리는 보다 효율적으로 test case를 작성하고 production code를 테스트할 수 있다.

## Keeping Tests Clean
Test code를 깔끔하게 작성하는 것의 중요성을 잘 알아차리지 못하는 경우가 많은데, **지저분한 test code는 test code를 안쓰니만 못하다**. Production code는 정적이지 않다. 시간이 지남에 따라 수정되고 발전한다. 이에 따른 test code의 수정이 필요한데, test code를 깔끔하지 않게 작성하였을 경우 이 작업에 많은 시간을 쏟아야 한다.

관리되지 않는 test code의 위험성은 다음과 같다. Production에 새로운 기능을 추가하기 위해서는 추가하는 code가 기존의 code와 충돌을 일으키지는 않는지, 의도한 대로 작동하는지 먼저 확인해야 한다. 너무 지저분해서 test code를 손볼 수 없는 상태에 이르면 이 확인 과정이 불가능해지고, production code는 발전하지 못한 채로 과거에 갇혀 썩어버리고 만다. 여기서 우리는 ***test code는 production code만큼 중요하다***는 사실을 알 수 있다.

### Tests Enable the -ilities
*Unit test*는 코드의 유연함과, 재사용성, 유지보수에 큰 도움이 된다. Test code가 커버할 수 있는 범위가 넓을수록 production의 자유도는 높아진다. 이런 이유에서 test가 `-ilities`를 가능하게 한다고 말한다. 

## Clean Tests
그렇다면 어떻게 해야 clean한 test code를 작성할 수 있을까? Clean test code에서 가장 중요한 점은 **Readability**이다. Test code의 readability는 production code에서보다 더 중요하다. 일반적인 코드를 작성할 때와 동일하게 명확하고 간단하며 의도한 바를 잘 나타내는 code를 우리는 readability가 있다고 말한다.

`BUILD-OPERATE-CHECK` pattern에 대한 이야기를 하는데 이 부분에 detail한 부분 찾아보기!

### A Dual Standard
Test code가 production code처럼 간단명료하고 명확해야 하지만, production만큼 효율적일 필요는 없다. Test code는 test environment에서 실행되기 때문에 고려할 부분이 약간은 다르다.

## One Assert per Test
한개의 test에서는 하나의 asserts만을 발생시켜야 한다는 관점이 있다. 복잡한 하나의 test를 여러개의 seperate tests로 나누면, 각각이 어떤 기능을 하는지 명확해진다는 장점이 있다. 반면, 오히려 코드의 반복이나 복잡성을 늘릴 수 있기 때문에 multi asserts을 사용하기도 한다. Multi asserts이라고 해서 마구잡이로 asserts을 쓰라는 뜻이 아니라 여러 asserts을 사용하되 최소한을 유지해야 한다는 의미이다.

`TEMPLATE METHOD` pattern에 대한 언급이 있음.

Asserts를 작성함에 있어 또다른 중요한 관점이 있다. 하나의 test function에서 여러 test를 진행하게 되면, 앞서 강조한 minimize asserts에 위배될 뿐만 아니라 readability를 감소시킨다.

정리하자면, 1. 최소한의 assert를 사용하고 2. 하나의 test function에서 하나의 concept에 대해서만 test를 진행해야 한다.

## F.I.R.S.T.
Clean test에 대한 rule은 다음과 같이 `F.I.R.S.T.`로 정리할 수 있다.

### **F**ast
Test code는 빨라야 한다. Production code를 작성하고 반복적으로 test code를 실행시켜 보며 오류를 찾고 디버깅을 수행해야 하기 때문에 느린 test code는 이에 부적합하다.

### **I**ndependent
각각의 test는 independent해야 한다. 하나의 test code가 다른 test code에 영향을 준다면 code를 디버깅하기 복잡해진다.

### **R**epetable
어떤 environment에서도 실행될 수 있어야 한다. Production environment와 QA environment 뿐만 아니라 test는 개인 laptop에서도 실행될 수 있어야 한다.

### **S**elf-Validating
Test는 성공 여부를 나타내는 `Boolean`값을 return해야 한다. 실행 결과를 일일히 비교하는 것은 테스트 결과를 재차 검증해야 하기 때문에 test code의 존재 의의에 맞지 않는다.

### **T**imely
적절한 타이밍에 test code를 작성해야 한다. Production code가 작성된 뒤에 test code를 쓰기에는 늦는다.

## Thoughts
생각해보면 지금까지 academic한 coding에서 test code를 작성해본 경험은 거의 전무한 것 같다. 남이 만들어 놓은 script나 예시 input을 사용해 본 적은 있지만, test code를 직접 작성하는 것은 이번 SD 수업을 들으면서가 처음이다. 말고는 서버를 코딩할 때 `NestJS`에서 제공하는 test code format 상에서 테스트를 해본 경험이 있다. 테스트의 중요성은 회사를 다니면서 여러 차례 경험을 했는데, 특히 게임 서버가 터지면 매출과 직결되어 있기 때문에 더욱 신중해야 했다. Test code를 production code 이전에 작성해야 한다는 개념은 처음 알게 되었는데, 직접 그 이유를 경험해 보고 싶다.
