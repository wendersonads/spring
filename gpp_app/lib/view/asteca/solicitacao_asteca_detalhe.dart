import 'package:auth_migration/domain/service/solicitacao_asteca_detalhe_service.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../shared/components/LoadingComponent.dart';
import '../../shared/widgets/NavBarWidget.dart';
import '../../widgets/sidebar_widget.dart';

class SolicitacaAstecaDetalhe extends StatelessWidget {
  final int id; 
  final controller;

  SolicitacaAstecaDetalhe({Key? key, required this.id})
      : controller = Get.put(SolicitacaAstecaDetalheService(id)),
        super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: const NavbarWidget(),
      drawer: const Sidebar(),
      body: Container(
        color: Colors.white,
        padding: const EdgeInsets.symmetric(
          vertical: 16,
          horizontal: 24,
        ),
        child: Obx(
          () => !controller.carregandoSolicitacao.value
              ? SingleChildScrollView(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      // _buildCamposIniciais(),
                      // _buildCamposNotaFiscalVenda(),
                      // _buildCamposNotaFiscalTroca(),
                      // _buildProduto(),
                      // _buildDefeitos(),
                      // _buildChecklist(),
                      // _buildCamposObservacoesAdicionais(),
                      // _buildImagens(),
                      // _buildCategoriaNumeroSerie(),
                      // _buildCategoriaCondicaProduto(),
                      // _buildCategoriaDefeito(),
                      // _buildVideos(controller.solicitacao.caminhoVideo),
                      // _buildDigitalizacoes(),
                      // _buildMotivoReprovacaoSolicitacaoOs(),
                      // _buildMotivoAprovacaoSolicitacaoOs(),
                      // _buildBotoesPrincipais(context),
                    ],
                  ),
                )
              : Center(
                  child: const LoadingComponent(),
                ),
        ),
      ),
    );
  }
}