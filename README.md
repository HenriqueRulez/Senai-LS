# Senai-LeanSurvey
Repositório do projeto SENAI-LeanSurvey


##Índice
 1. Getting Started
 2. Refs para estudo/dúvidas
 3. Tips!





### 1 - Getting Started

Alguns comandos básicos para o uso apropriado do `Git`.

_Caso não tenha o git instalado em seu computador, faça o download [aqui](https://git-for-windows.github.io/)_

---
Iniciando o git na pasta determinada:
```
git init
```
---
Apontando o repositório de onde você quer receber/enviar arquivos:
```
git remote add origin https://github.com/VitorFerraz/Senai-LeanSurvey
```
---
Configurando os usuários globais em sua máquina:
```
git config --global user.name "SeuNomeNoGit"
git config --global user.email "OSeuEmailCadastradoNoGit"
```
---
Caso queira editar/excluir os usuários globais:
```
git config --global --edit
```
---
Puxando os arquivos do GitHub e adiciona ao seu repositório local:
```
git pull
```

  > Pode-se utilizar o git pull --rebase para SOBREPOR todos os seus arquivos locais.
  
---
Mesclando os arquivos do repositótio no GitHub com os locais:
```
git fetch --all
```
 > --all mescla todos os branches
 
---
Adicionando os itens ao commit:
```
git add <NOME DO ARQUIVO>
git add .
```
> Utiliza-se . para dar commit em todos os arquivos modificados.

---
Commitando os arquivos selecionados:
```
git commit -m "MENSAGEM"
```
   > -m "MENSAGEM", adiciona uma mensagem ao seu commit. (SEMPRE EXPLICAR O QUE ESTÁ SENDO COMMITADO)
   
---
Enviando os arquivos commitados para o GitHub:
```
git push origin master
```
---

### 2. Refs para estudo/dúvidas

| Links        | Descrição           |
| ------------- |:-------------:| 
| [Mudar de branch](https://help.github.com/articles/changing-a-remote-s-url/)     | Tuto para mudar de branches e usuários | $1600 |
| [Comandos](https://github.com/git-tips/tips)     | Configuração do git e comandos em geral      |  
| [Configs para GitHub](https://github.com/tiimgreen/github-cheat-sheet/blob/master/README.md)|Muitas configurações para GitHub!     | 
|[Testdrive de Git](https://try.github.io/) | Teste o git sem medo de ser feliz |


### 3. Tips!

 

**Moiou, no almoço eu continuo.**
