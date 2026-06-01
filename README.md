# 📱 Aplicativo Android Encurtador de URL

- Aplicação Android desenvolvido em **Kotlin** utilizando **Jetpack Compose**, que permite encurtar URLs de forma rápida e prática.
- Desenvolvido visando boas práticas no desenvolvimento.

 ---

 ## 🚀 1. Funcionalidades
 - Encurtar URLs longas em URLs curtas utilizando API externa.
 - Copiar URLs encurtadas para a área de transferência com um toque.
 - Histórico de URLs encurtadas.
 - Interface amigável e responsiva com Material Design.
 - Persistencia local utilizando Room Database.
 - Arquitetura organizada seguindo boas práticas, afim de garantir separação de responsabilidades e facilidade de manutenção..
 
 ---
 
 ## 🛠️ 2. Tecnologias Utilizadas
 - **Kotlin**
 - **Android Jetpack** 
 - **Material Design**
 - **Retrofit** para chamadas de API
 - **Room Database** para persistência local
 - **Coroutines** para operações assíncronas

 ---

 ## 📦 3. Requisitos do Sistema
 - Android Studio Bumblebee ou superior
 - SDK Android 21 ou superior
 - Conexão com a internet para encurtar URLs
 
 ---
 
 ## ⚙️ 4. Configuração do Ambiente
 1. Instale o [Android Studio](https://developer.android.com/studio).
 2. Configure o SDK Android (mínimo API 21).
 3. Clone este repositório:
    ```bash
    git clone https://github.com/Danimmota/encurtadorurl.git
    ```
4. Abra o projeto no Android Studio.
5. Aguarde o Gradle sincronizar.
6. Conecte um dispositivo físico ou emulador Android.
7. Rode o app com ▶ Run App.
8. Pronto! Agora você pode encurtar URLs diretamente do seu dispositivo Android.

 ---
 ## 📚 5. Estrutura do Projeto

- `data/` - Camada de dados, incluindo modelo, DAO e repositório.
- `feature/` - Camada de apresentação, contendo as telas e componentes de UI.
- `network/` - Configuração da API Retrofit e serviços de rede.

 ---

 ## 📚 6. Boas praticas adotadas
- Separação de camadas
- Persistência local com Room
- Composables organizados e reutilizáveis
- Código limpo e legível

 ## 📦 7. Dependências
- **Kotlin Standard Library**: Biblioteca padrão do Kotlin.
- **Jetpack Compose**: Biblioteca para construção de interfaces de usuário declarativas.
- **Retrofit**: Biblioteca para chamadas HTTP.
- **Room**: Biblioteca para persistência local.
- **Navigation Compose**: Biblioteca do Compose para navegação entre telas.
- **Coroutines**: Suporte para programação assíncrona.
- **Material Design Components**: Componentes de UI seguindo as diretrizes do Material Design.

---
## 📱 8. Tela de Login

- [Tela de Login](docs/images/login_encurtador.png)

## 🏠 9. Tela Principal com histórico de URLs encurtadas

 - [Histórico de URLs e detalhes](docs/images/historyandDetails.png)
   
 ---
 ## 10. Autor
 - **Daniela Mota** - Desenvolvedora Backend & Mobile